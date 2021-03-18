package controllers;

import java.sql.SQLException;

import db.ProductDB;

public class ProductController {
	private ProductDB productDb;

	public ProductController() {
		try {
			this.productDb = new ProductDB();
		} catch (SQLException e) {
			System.out.println("Could not instantiate ProductDB.");
		}
	}
}
