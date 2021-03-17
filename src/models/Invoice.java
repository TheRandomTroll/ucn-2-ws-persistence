package models;


import java.sql.Date;

public class Invoice {
	private int id;
	private SaleOrder order;
	private int invoiceNo;
	private Date paymentDate;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SaleOrder getOrder() {
		return order;
	}

	public void setOrder(SaleOrder order) {
		this.order = order;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
