package controllers;

import java.sql.SQLException;
import java.util.List;

import db.OrderDB;
import models.Customer;
import models.Invoice;
import models.Product;
import models.SaleOrder;

public class OrderController {
	private OrderDB orderDb;
	private CustomerController customerController;
	private InvoiceController invoiceController;

	public OrderController() {
		try {
			this.orderDb = new OrderDB();
			this.customerController = new CustomerController();
			this.invoiceController = new InvoiceController();
		} catch (SQLException e) {
			System.out.println("Could not instantiate OrderDB.");
		}
	}

	public Invoice createOrder(List<Product> products, String customerPhoneNo) {
		Customer customer = this.customerController.findByPhoneNo(customerPhoneNo);
		SaleOrder order = this.orderDb.addOrder(products, customer);
		return this.invoiceController.createInvoice(order);
	}
}
