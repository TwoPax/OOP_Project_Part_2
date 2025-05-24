package Model;

import java.util.ArrayList;

public class MainManager extends Manager{
	private String userName;
	private String password;
	public MainManager(String id, String firstName, String lastName, String phone, String address, ArrayList<Taxi> taxies,
			ArrayList<Order> orders, String userName, String password) {
		super(id, firstName, lastName, phone, address, taxies, orders);
		this.userName = userName;
		this.password = password;
	}
	
	public MainManager(String id, String firstName, String lastName, String phone, String address,
		 String userName, String password) {
		super(id, firstName, lastName, phone, address);
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MainManager [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", password="
				+ password + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", taxies="
				+ taxies + ", taxisNum=" + taxisNum + ", orders=" + orders + ", ordersNum=" + ordersNum + "]";
	}

	
	
}
