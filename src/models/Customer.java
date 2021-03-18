package models;

public class Customer {
	private int id;
	private String name;
	private String address;
	private int zipcode;
	private String city;
	private String phoneNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", zipcode=" + zipcode +
				", city='" + city + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				'}';
	}
}
