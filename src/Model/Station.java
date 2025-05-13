package Model;

import java.util.Arrays;

public class Station {
	private String stationName;
	private Taxi[] taxis;
	private int taxisNum;
	public Station(String stationName, Taxi[] taxis) {
		super();
		this.stationName = stationName;
		this.taxis = taxis;
		this.taxisNum = taxis.length;
	}
	
	
	public Station(String stationName) {
		super();
		this.stationName = stationName;
		this.taxis = new Taxi[0];
		this.taxisNum = 0;
	}


	public String getStationName() {
		return stationName;
	}


	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


	public Taxi[] getTaxis() {
		return taxis;
	}


	public void setTaxis(Taxi[] taxis) {
		this.taxis = taxis;
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


	@Override
	public String toString() {
		return "Station [stationName=" + stationName + ", taxis=" + Arrays.toString(taxis) + ", taxisNum=" + taxisNum
				+ "]";
	}
	

}
