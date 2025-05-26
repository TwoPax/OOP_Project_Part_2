package Control;

import java.util.Arrays;

import Model.*;

public class Systemhw { //OLD DB
	private Subscription[] subscriptions;
	private int subscriptionsNum;
	private Manager[] managers;
	private int managersNum;
	private Taxi[] taxis;
	private int taxisNum;
	
	
	public Systemhw(Subscription[] subscriptions, Manager[] managers, Taxi[] taxis) {
		super();
		this.subscriptions = subscriptions;
		subscriptionsNum = subscriptions.length;
		this.managers = managers;
		managersNum = managers.length;
		this.taxis = taxis;
		taxisNum = taxis.length;

	}

	public Systemhw() {
		super();
		this.subscriptions = new Subscription[0];
		subscriptionsNum = 0;
		this.managers = new Manager[0];
		managersNum = 0 ;
		this.taxis = new Taxi[0];
		taxisNum = 0 ;

	}

	

	public boolean addSubscription(Subscription newSubscription) { 
		if(newSubscription==null) return false;
		for(Subscription subscription:subscriptions) {
			if(newSubscription.getSubCode().equals(subscription.getSubCode())) return false;
		}
		subscriptions = Arrays.copyOf(subscriptions, subscriptionsNum+1);
		subscriptions[subscriptionsNum] = newSubscription;
		subscriptionsNum++;
		return true;	
	}
	
	public boolean removeSubscription(Subscription subscriptionToremove) {
		if(subscriptionToremove==null) return false;
		boolean founded=false;
		int index =0;

		for(int i=0 ; i<subscriptionsNum ; i++) {
			if(subscriptionToremove.getSubCode().equals(subscriptions[i].getSubCode())) {
				founded=true;
				index= i;
			}
		}

		if(!founded) return false;
		
		for(int i=index ; i<subscriptionsNum-1 ; i++)
			subscriptions[i]=subscriptions[i+1];
		
		subscriptions = Arrays.copyOf(subscriptions, subscriptionsNum-1);
		subscriptionsNum--;
		return true;
	}
	
	
	
	public boolean addManager(Manager newManager) {
		if(newManager==null) return false;
		for(Manager manager:managers) {
			if(newManager.getId().equals(manager.getId())) return false;
		}
		managers = Arrays.copyOf(managers, managersNum+1);
		managers[managersNum] = newManager;
		managersNum++;
		return true;	
	}
	
	public boolean removeManager(Manager managerToremove) {
		if(managerToremove==null) return false;
		boolean founded=false;
		int index =0;

		for(int i=0 ; i<managersNum ; i++) {
			if(managerToremove.getId().equals(managers[i].getId())) {
				founded=true;
				index= i;
			}
		}

		if(!founded) return false;
		
		for(int i=index ; i<managersNum-1 ; i++)
			managers[i]=managers[i+1];
		
		managers = Arrays.copyOf(managers, managersNum-1);
		managersNum--;
		return true;
	}

	
	
	

	
	public boolean addTaxi(Taxi newTaxi) { 
		if(newTaxi==null) return false;
		for(Taxi taxi:taxis) {
			if(newTaxi.getTaxiCode().equals(taxi.getTaxiCode())) {
				return false;
			}
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

	public Subscription[] getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Subscription[] subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Manager[] getManagers() {
		return managers;
	}

	public void setManagers(Manager[] managers) {
		this.managers = managers;
	}

	public Taxi[] getTaxis() {
		return taxis;
	}

	public void setTaxis(Taxi[] taxis) {
		this.taxis = taxis;
	}

	@Override
	public String toString() {
		return "Systemhw [subscriptions=" + Arrays.toString(subscriptions) + ", managers=" + Arrays.toString(managers)
				+ ", taxis=" + Arrays.toString(taxis) + "]";
	}


}
