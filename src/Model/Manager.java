package Model;

import java.util.ArrayList;

public class Manager {
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String address;
	protected ArrayList<Taxi> taxies;
	protected int taxisNum;
	protected ArrayList<Order> orders;
	protected int ordersNum;
	
	//Constructors
	public Manager(String id, String firstName, String lastName, String phone, String address, ArrayList<Taxi> taxies,
		ArrayList<Order> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.taxies = taxies;
		this.taxisNum = taxies.size();
		this.orders = orders;
		this.ordersNum = orders.size();
	}

	public Manager(String id, String firstName, String lastName, String phone, String address) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
			this.taxies = new ArrayList<>();
			this.taxisNum = 0;
			this.orders = new ArrayList<>();
			this.ordersNum = 0;
		}
	public Manager(){
		super();
		this.id = null;
		this.firstName = null;
		this.lastName = null;
		this.phone = null;
		this.address = null;
		this.taxies = new ArrayList<>();
		this.taxisNum = 0;
		this.orders = new ArrayList<>();
		this.ordersNum = 0;
	}

	//Getters and Setters
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

	public ArrayList<Taxi> getTaxies() {
		return taxies;
	}

	public void setTaxies(ArrayList<Taxi> taxies) {
		this.taxies = taxies;
		this.taxisNum = taxies.size();
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
		this.ordersNum = orders.size();
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", address=" + address + ", taxies=" + taxies + ", taxisNum=" + taxisNum + ", orders=" + orders
				+ ", ordersNum=" + ordersNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/*
	 * Input: A new Taxi
	 * Effect: Adds the taxi to the list of taxies in charge
	 * Output: True if added succesfully, false otherwise
	 */
	public boolean addTaxi(Taxi newTaxi) {
		if(newTaxi == null){
            return false;
        }
        if(taxies.contains(newTaxi)){
            return false;
        }
        taxies.add(newTaxi);
		taxisNum++;
        return true;
			
	}
	/*
	 * Input: A taxi to remove
	 * Effect: If legal, removes taxi from manager's in charge list
	 * Output: True if removed succesfully, false otherwise 
	 */
	public boolean removeTaxi(Taxi taxiToremove) {
		if(taxiToremove == null){
			return false;
		}
		if(!taxies.contains(taxiToremove)){
			return false;
		}
		int taxiIndex = taxies.indexOf(taxiToremove);
		taxies.remove(taxiIndex);
		taxisNum--;
		return true;
	}
	
	/*
	 * Input: A new Order
	 * Effect: Adds the order to the list of orders made by manager
	 * Output: True if added succesfully, false otherwise
	 */
	public boolean addOrder(Order newOrder) {
		if(newOrder == null){
            return false;
        }
        if(orders.contains(newOrder)){
            return false;
        }
        orders.add(newOrder);
		ordersNum++;
        return true;


			
	}
	/*
	 * Input: An order to remove
	 * Effect: Removes the order from the list of orders made by manager
	 * Output: True if removed succesfully, false otherwise
	 */
	public boolean removeOrder(Order orderToremove) {
		if(orderToremove == null){
			return false;
		}
		if(!orders.contains(orderToremove)){
			return false;
		}
		int orderIndex = orders.indexOf(orderToremove);
		orders.remove(orderIndex);
		ordersNum--;
		return true;
		
		

		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

