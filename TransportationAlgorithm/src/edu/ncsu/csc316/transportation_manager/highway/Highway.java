package edu.ncsu.csc316.transportation_manager.highway;

public class Highway {

	private int city1;
	private int city2;
	private double cost;
	private double asphalt;
	
	public Highway(int a, int b, double c, double d) {
		this.city1 = a;
		this.city2 = b;
		this.cost = c;
		this.asphalt = d;
	}
	
	public int getCity1() {
		return city1;
	}
	
	public int getCity2() {
		return city2;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getAsphalt() {
		return asphalt;
	}
	
	/**
	 * Returns a string representation of the Highway
	 * in the format:
	 * 
	 * Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * 
	 * @return the string representation of the highway
	 */
	@Override
	public String toString() {
		return "Highway[city1=" + city1 +", city2=" + city2 + ", cost=" + cost +", asphalt=" + asphalt +"]";
	}
}
