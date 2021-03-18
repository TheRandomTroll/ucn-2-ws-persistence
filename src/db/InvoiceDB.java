package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

import db.interfaces.InvoiceDBIF;
import models.Invoice;
import models.Product;
import models.SaleOrder;

public class InvoiceDB implements InvoiceDBIF {
	private static final String INSERT_INVOICE_Q = "INSERT INTO Invoices(SaleOrderId, InvoiceNo, PaymentDate, Amount) VALUES (?, ?, ?, ?)";

	private final PreparedStatement insertInvoicePS;

	public InvoiceDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		insertInvoicePS = con.prepareStatement(INSERT_INVOICE_Q);
	}

	@Override
	public Invoice addInvoice(SaleOrder order) {
		Invoice i = new Invoice();
		i.setOrder(order);
		i.setPaymentDate(Date.valueOf(LocalDate.now()));
		Random rnd = new Random();
		int invoiceNo = 100000 + rnd.nextInt(900000);
		i.setInvoiceNo(invoiceNo);
		double amount = 0.0;
		for (Product p : order.getProducts()) {
			amount += p.getSalesPrice();
		}

		i.setAmount(amount);

		try {
			insertInvoicePS.setInt(1, order.getId());
			insertInvoicePS.setInt(2, i.getInvoiceNo());
			insertInvoicePS.setDate(3, i.getPaymentDate());
			insertInvoicePS.setDouble(4, i.getAmount());

			insertInvoicePS.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error saving invoice to database: " + e.getMessage());
		}

		return i;
	}
}
