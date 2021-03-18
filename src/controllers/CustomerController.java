package controllers;

import java.sql.SQLException;

import db.CustomerDB;
import models.Customer;

public class CustomerController {
	private CustomerDB customerDB;

	public CustomerController() {
		try {
			this.customerDB = new CustomerDB();
		} catch (SQLException e) {
			System.out.println("Could not instantiate CustomerDB.");
		}
	}

	public Customer findByPhoneNo(String phoneNo) {
		return this.customerDB.findByPhoneNo(phoneNo);
	}
}
