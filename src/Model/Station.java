package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Station {
	private String stationName;
	private ArrayList<Taxi> taxiesInStation;
	private int taxisNum;
	public Station(String stationName, ArrayList<Taxi> taxis) {
		super();
		this.stationName = stationName;
		this.taxiesInStation = taxis;
		this.taxisNum = taxis.size();
	}
	
	
	public Station(String stationName) {
		super();
		this.stationName = stationName;
		this.taxiesInStation = new ArrayList<>();
		this.taxisNum = 0;
	}


	public String getStationName() {
		return stationName;
	}


	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


	public ArrayList<Taxi> getTaxis() {
		return taxiesInStation;
	}


	public void setTaxis(ArrayList<Taxi> taxis) {
		this.taxiesInStation = taxis;
	}
	@Override
	public String toString() {
		return "Station [stationName=" + stationName + ", taxiesInStation=" + taxiesInStation + ", taxisNum=" + taxisNum
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
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
		Station other = (Station) obj;
		if (stationName == null) {
			if (other.stationName != null)
				return false;
		} else if (!stationName.equals(other.stationName))
			return false;
		return true;
	}
	
	/*
	 * Input: A new Taxi
	 * Effect: Adds the taxi to array list of all taxis in Station
	 * Output: True if added succesfully, false otherwise
	 */
	public boolean addTaxi(Taxi newTaxi) {
		if(newTaxi==null){
			System.out.println("Enter none null values");
			return false;
		}
		if(taxiesInStation.contains(newTaxi)){
			System.out.println("Taxi already in station");
			return false;

		}
		taxiesInStation.add(newTaxi);
		System.out.println("Taxi added succesfully to station");
		return true;
	}

	/*
	 * Input: A taxi to remove from station
	 * Effect: Removes taxi from array list of all taxis in Station
	 * Output: True if remobed succesfully, false otherwise
	 */
	public boolean removeTaxi(Taxi taxiToremove) {
		if(taxiToremove==null){
			System.out.println("Can not remove null value");
			return false;
		}
		if(!taxiesInStation.contains(taxiToremove)){
			System.out.println("Failure - taxi is not in station");
			return false;
		}
		int indexToRemove = taxiesInStation.indexOf(taxiToremove);
		taxiesInStation.remove(indexToRemove);
		System.out.println("Taxi removes succesfully from station");
		return true;
	}



	


	
	

}
