package Model;

import java.util.Arrays;

public class Manager {
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String address;
	protected Taxi[] taxis;
	protected int taxisNum;
	protected Order[] orders;
	protected int ordersNum;
	
	public Manager(String id, String firstName, String lastName, String phone, String address, Taxi[] taxis,
		Order[] orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.taxis = taxis;
		this.taxisNum = taxis.length;
		this.orders = orders;
		this.ordersNum = orders.length;
	}

	public Manager(String id, String firstName, String lastName, String phone, String address) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
			this.taxis = new Taxi[0];
			this.taxisNum = 0;
			this.orders = new Order[0];
			this.ordersNum = 0;
		}
	
	public Manager(String id, String firstName, String lastName, String phone, String address, 
			Order[] orders) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
			this.taxis = new Taxi[0];
			this.taxisNum = 0;
			this.orders = orders;
			this.ordersNum = orders.length;
		}
	
	public Manager(String id, String firstName, String lastName, String phone, String address, Taxi[] taxis) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
			this.taxis = taxis;
			this.taxisNum = taxis.length;
			this.orders = new Order[0];
			this.ordersNum = 0;
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Taxi[] getTaxis() {
		return taxis;
	}

	public void setTaxis(Taxi[] taxis) {
		this.taxis = taxis;
	}

	public Order[] getOrders() {
		return orders;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}
	
	public boolean addTaxi(Taxi newTaxi) {
		if(newTaxi==null) return false;
		for(Taxi taxi:taxis) {
			if(newTaxi.getTaxiCode().equals(taxi.getTaxiCode())) return false;
		}
		taxis = Arrays.copyOf(taxis, taxisNum+1);
		taxis[taxisNum] = newTaxi;
		taxisNum++;
		return true;	
	}
	
	public boolean removeTaxi(Taxi taxiToremove) {
		if(taxiToremove==null) return false;
		boolean founded=false;
		int index =0;

		for(int i=0 ; i<taxisNum ; i++) {
			if(taxiToremove.getTaxiCode().equals(taxis[i].getTaxiCode())) {
				founded=true;
				index= i;
			}
		}

		if(!founded) return false;
		
		for(int i=index ; i<taxisNum-1 ; i++)
			taxis[i]=taxis[i+1];
		
		taxis = Arrays.copyOf(taxis, taxisNum-1);
		taxisNum--;
		return true;
	}
	
	
	public boolean addOrder(Order newOrder) {
		if(newOrder==null) return false;
		for(Order order:orders) {
			if(newOrder.getOrderNum().equals(order.getOrderNum())) return false;
		}
		orders = Arrays.copyOf(orders, ordersNum+1);
		orders[ordersNum] = newOrder;
		ordersNum++;
		return true;	
	}
	
	public boolean removeOrder(Order orderToremove) {
		if(orderToremove==null) return false;
		boolean founded=false;
		int index =0;

		for(int i=0 ; i<ordersNum ; i++) {
			if(orderToremove.getOrderNum().equals(orders[i].getOrderNum())) {
				founded=true;
				index= i;
			}
		}

		if(!founded) return false;
		
		for(int i=index ; i<ordersNum-1 ; i++)
			orders[i]=orders[i+1];
		
		orders = Arrays.copyOf(orders, ordersNum-1);
		ordersNum--;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", address=" + address + ", taxis=" + Arrays.toString(taxis) + ", taxisNum=" + taxisNum + ", orders="
				+ Arrays.toString(orders) + ", ordersNum=" + ordersNum + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
