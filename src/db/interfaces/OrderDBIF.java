package db.interfaces;

import java.util.List;

import models.Customer;
import models.Product;
import models.SaleOrder;

public interface OrderDBIF {
	SaleOrder addOrder(List<Product> products, Customer customer);
}
