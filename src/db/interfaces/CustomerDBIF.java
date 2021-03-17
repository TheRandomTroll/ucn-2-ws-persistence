package db.interfaces;

import models.Customer;

public interface CustomerDBIF {
	public Customer findByPhoneNo(String phoneNo);
}
