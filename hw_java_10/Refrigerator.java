package com.ssafy.edu.hw9;

public class Refrigerator extends Product {

	private int capacity;

	public Refrigerator() {
		super();
	}

	public Refrigerator(String no, String name, int price, int amount, int capacity) {
		super(no, name, price, amount);
		this.capacity=capacity;
	}
	public Refrigerator(String no, String name, int price, int amount) {
		this(no, name, price, amount,0);
	}

	@Override
	public String toString() {
		return no + "|" + name + "|" + price + "|" + amount + "|" + capacity;
	}



	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


}
