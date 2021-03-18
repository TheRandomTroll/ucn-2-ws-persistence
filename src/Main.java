import java.sql.SQLException;
import java.util.List;

import db.CustomerDB;
import db.ProductDB;
import models.Customer;
import models.Product;

public class Main {

	public static void main(String[] args) throws SQLException {
		CustomerDB db = new CustomerDB();
		Customer c = db.findByPhoneNo("+4512345678");
		System.out.println(c.toString());

		ProductDB db2 = new ProductDB();

		List<Product> products = db2.getProducts();

		for (Product p : products) {
			System.out.println(p.toString());

		}
	}
}
