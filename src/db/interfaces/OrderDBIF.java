package db.interfaces;

import java.util.List;

import models.Customer;
import models.Product;

public interface OrderDBIF {
	void addOrder(List<Product> products, Customer customer);
}
