package com.ssafy.edu.hw11;

import java.io.Serializable;

public class Refrigerator extends Product implements Serializable{

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
		return "Refrigerator [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + ", capacity=" + capacity + "]";
	}



	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


}
