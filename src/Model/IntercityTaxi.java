package Model;

import java.util.ArrayList;


public class IntercityTaxi extends Taxi {
	
	private ArrayList<String> cities;
	private int citiesNum ;
	private double extraPrice;
	private int maxHours;

	//Constructors
	public IntercityTaxi(String taxiCode, boolean available, double minPrice, ArrayList<String> cities,
			double extraPrice, int maxHours) {
		super(taxiCode, available, minPrice);
		this.cities = cities;
		this.citiesNum = cities.size();
		this.extraPrice = extraPrice;
		this.maxHours = maxHours;
	}
	
	public IntercityTaxi(String taxiCode, boolean available, double minPrice, double extraPrice, int maxHours) {
		super(taxiCode, available, minPrice);
		this.cities = new ArrayList<>();
		this.citiesNum = 0;
		this.extraPrice = extraPrice;
		this.maxHours = maxHours;
	}
	public IntercityTaxi(){
		super();
		this.cities = new ArrayList<>();
		this.citiesNum = 0;
		this.extraPrice = 0;
		this.maxHours = 0;
	}

	//Getters and Setters
	public ArrayList<String> getCities() {
		return cities;
	}


	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
		this.citiesNum = cities.size();
	}


	public int getCitiesNum() {
		return citiesNum;
	}


	public void setCitiesNum(int citiesNum) {
		this.citiesNum = citiesNum;
	}


	public double getExtraPrice() {
		return extraPrice;
	}


	public void setExtraPrice(double extraPrice) {
		this.extraPrice = extraPrice;
	}


	public int getMaxHours() {
		return maxHours;
	}


	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}

	
	@Override
	public String toString() {
		return "IntercityTaxi [taxiCode=" + taxiCode + ", available=" + available + ", minPrice=" + minPrice
				+ ", cities=" + cities + ", citiesNum=" + citiesNum + ", extraPrice=" + extraPrice + ", maxHours="
				+ maxHours + "]";
	}


	/*
	 * Input: A new city
	 * Effect: If legal, adds city to array list of cities taxi can go to
	 * Output: True if added succesfully, false otherwise
	 */
	public boolean addCity(String newCity) {
		if(newCity == null){
			return false;
		}
		if(cities.contains(newCity)){
			return false;
		}
		cities.add(newCity);
		citiesNum++;
		return true;
	}
	/*
	 * Input: A city to remove
	 * Effect: If legal, removes city from array list of cities taxi can go to
	 * Output: True if removed succesfuly, false otherwise
	 */
	public boolean removeCity(String cityToRemove){
		if(cityToRemove == null){
			return false;
		}
		if(!cities.contains(cityToRemove)){
			return false;
		}
		int cityIndex = cities.indexOf(cityToRemove);
		cities.remove(cityIndex);
		citiesNum--;
		return true;
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
