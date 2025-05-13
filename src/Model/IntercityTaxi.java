package Model;

import java.util.Arrays;

public class IntercityTaxi extends Taxi {
	private String[] cities;
	private int citiesNum ;
	private double extraPrice;
	private int maxHours;
	public IntercityTaxi(String taxiCode, boolean available, double minPrice, String[] cities,
			double extraPrice, int maxHours) {
		super(taxiCode, available, minPrice);
		this.cities = cities;
		this.citiesNum = cities.length;
		this.extraPrice = extraPrice;
		this.maxHours = maxHours;
	}
	
	
	public IntercityTaxi(String taxiCode, boolean available, double minPrice, double extraPrice, int maxHours) {
		super(taxiCode, available, minPrice);
		this.cities = new String[0];
		this.citiesNum = 0;
		this.extraPrice = extraPrice;
		this.maxHours = maxHours;
	}


	public String[] getCities() {
		return cities;
	}


	public void setCities(String[] cities) {
		this.cities = cities;
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
	
	public boolean addCity(String newCity) {
		if(newCity==null) return false;
		for(String city:cities) {
			if(city.equals(newCity)) return false;
		}
		cities = Arrays.copyOf(cities, citiesNum+1);
		cities[citiesNum] = newCity;
		citiesNum++;
		return true;	
	}
	
	public boolean removeCity(String cityToRemove) {
		if(cityToRemove==null) return false;
		boolean founded=false;
		int index =0;

		for(int i=0 ; i<citiesNum ; i++) {
			if(cities[i].equals(cityToRemove)) {
				founded=true;
				index= i;
			}
		}

		if(!founded) return false;
		
		for(int i=index ; i<citiesNum-1 ; i++)
			cities[i]=cities[i+1];
		
		cities = Arrays.copyOf(cities, citiesNum-1);
		citiesNum--;
		return true;
	}


	@Override
	public String toString() {
		return "IntercityTaxi [cities=" + Arrays.toString(cities) + ", citiesNum=" + citiesNum + ", extraPrice="
				+ extraPrice + ", maxHours=" + maxHours + ", taxiCode=" + taxiCode + ", available=" + available
				+ ", minPrice=" + minPrice + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
