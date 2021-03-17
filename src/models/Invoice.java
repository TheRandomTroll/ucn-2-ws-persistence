package models;

import java.time.LocalDate;

public class Invoice {
	private int id;
	private SaleOrder order;
	private int invoiceNo;
	private LocalDate paymentDate;
	private double amount;
}
