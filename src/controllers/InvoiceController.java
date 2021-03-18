package controllers;

import java.sql.SQLException;

import db.InvoiceDB;
import models.Invoice;
import models.SaleOrder;

public class InvoiceController {
	private InvoiceDB invoiceDb;

	public InvoiceController() {
		try {
			this.invoiceDb = new InvoiceDB();
		} catch (SQLException e) {
			System.out.println("Could not instantiate InvoiceDB.");
		}
	}

	public Invoice createInvoice(SaleOrder order) {
		return this.invoiceDb.addInvoice(order);
	}
}
