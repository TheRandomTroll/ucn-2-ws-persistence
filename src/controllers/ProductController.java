package controllers;

import java.sql.SQLException;
import java.util.List;

import db.ProductDB;
import models.Product;

public class ProductController {
	private ProductDB productDb;

	public ProductController() {
		try {
			this.productDb = new ProductDB();
		} catch (SQLException e) {
			System.out.println("Could not instantiate ProductDB.");
		}
	}

	public List<Product> getProducts() {
		return this.productDb.getProducts();
	}

	public Product findByBarcode(int barcode) {
		return this.productDb.findByBarcode(barcode);
	}
}
