package Model;

public class Taxi {
	protected String taxiCode;
	protected boolean available ; 
	protected double minPrice;
	
	
	//Constructors
	public Taxi(String taxiCode, boolean available, double minPrice) {
		super();
		this.taxiCode = taxiCode;
		this.available = available;
		this.minPrice = minPrice;
	}
	public Taxi(){
		super();
		this.taxiCode = null;
		this.available = false;
		this.minPrice = 0;
	}
	//Getters and Setters
	public String getTaxiCode() {
		return taxiCode;
	}
	public void setTaxiCode(String taxiCode) {
		this.taxiCode = taxiCode;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	@Override
	public String toString() {
		return "Taxi [taxiCode=" + taxiCode + ", available=" + available + ", minPrice=" + minPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taxiCode == null) ? 0 : taxiCode.hashCode());
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
		Taxi other = (Taxi) obj;
		if (taxiCode == null) {
			if (other.taxiCode != null)
				return false;
		} else if (!taxiCode.equals(other.taxiCode))
			return false;
		return true;
	}
	
	
	

}
