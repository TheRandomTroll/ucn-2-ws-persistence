import java.sql.SQLException;

import db.CustomerDB;
import models.Customer;

public class Main {

	public static void main(String[] args) throws SQLException {
		CustomerDB db = new CustomerDB();
		Customer c = db.findByPhoneNo("+4512345678");
		System.out.println(c.toString());
	}

}
