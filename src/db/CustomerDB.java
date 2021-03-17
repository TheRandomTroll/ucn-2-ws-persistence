package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.interfaces.CustomerDBIF;
import models.Customer;

public class CustomerDB implements CustomerDBIF {
	private static final String FIND_BY_PHONE_NO_Q = "SELECT Id, Name, Address, Zipcode, City, PhoneNo FROM Customers WHERE PhoneNo = ?";
	
	private final PreparedStatement findByPhoneNoPS;
	public CustomerDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		findByPhoneNoPS = con.prepareStatement(FIND_BY_PHONE_NO_Q);
	}
	
	@Override
	public Customer findByPhoneNo(String phoneNo) {
		Customer c = null;
		
		try {
			findByPhoneNoPS.setString(1, phoneNo);
			ResultSet rs = findByPhoneNoPS.executeQuery();
			if (rs.next()) {
				c = buildObject(rs);
			}
		} catch (SQLException e) {
			System.out.println("Error fetching customer from database: " + e.getMessage());
		}
		
		return c;
	}

	private Customer buildObject(ResultSet rs) {
		Customer c = new Customer();
		try {
			c.setName(rs.getString("Name"));
			c.setAddress(rs.getString("Address"));
			c.setZipcode(rs.getInt("Zipcode"));
			c.setCity(rs.getString("City"));
			c.setPhoneNo(rs.getString("PhoneNo"));
		} catch (SQLException e) {
			System.out.println("Error parsing customer: " + e.getMessage());
		}
		return c;
	}

}
