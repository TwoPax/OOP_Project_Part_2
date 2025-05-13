package Model;

import java.util.Arrays;

public class MainManager extends Manager{
	private String userName;
	private String password;
	public MainManager(String id, String firstName, String lastName, String phone, String address, Taxi[] taxis,
			Order[] orders, String userName, String password) {
		super(id, firstName, lastName, phone, address, taxis, orders);
		this.userName = userName;
		this.password = password;
	}
	
	public MainManager(String id, String firstName, String lastName, String phone, String address,
			Order[] orders, String userName, String password) {
		super(id, firstName, lastName, phone, address,  orders);
		this.userName = userName;
		this.password = password;
	}
	public MainManager(String id, String firstName, String lastName, String phone, String address, Taxi[] taxis,
			 String userName, String password) {
		super(id, firstName, lastName, phone, address, taxis);
		this.userName = userName;
		this.password = password;
	}
	public MainManager(String id, String firstName, String lastName, String phone, String address, String userName, String password) {
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
		return "MainManager [userName=" + userName + ", password=" + password + ", id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", taxis="
				+ Arrays.toString(taxis) + ", taxisNum=" + taxisNum + ", orders=" + Arrays.toString(orders)
				+ ", ordersNum=" + ordersNum + "]";
	}
	
}
