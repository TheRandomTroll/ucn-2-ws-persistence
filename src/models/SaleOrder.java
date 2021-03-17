package models;

import java.time.LocalDate;
import java.util.List;

import models.enums.DeliveryStatus;

public class SaleOrder {
	private int id;
	private Customer customer;
	private List<Product> products;
	private LocalDate date;
	private double amount;
	private DeliveryStatus deliveryStatus;
	private LocalDate deliveryDate;
}
