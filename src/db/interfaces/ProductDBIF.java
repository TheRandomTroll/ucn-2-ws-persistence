package db.interfaces;

import java.util.List;

import models.Product;

public interface ProductDBIF {
	List<Product> getProducts();

	Product findByBarcode();
}
