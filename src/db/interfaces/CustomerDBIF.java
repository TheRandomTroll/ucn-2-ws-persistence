package db.interfaces;

import models.Customer;

public interface CustomerDBIF {
	Customer findByPhoneNo(String phoneNo);
}
