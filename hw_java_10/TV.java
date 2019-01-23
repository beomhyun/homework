package com.ssafy.edu.hw9;

public class TV extends Product {

	private int wide;

	public TV() {
		super();
	}

	public TV(String no, String name, int price, int amount, int wide) {
		super(no, name, price, amount);
		this.wide=wide;
	}
	public TV(String no, String name, int price, int amount) {
		this(no, name, price, amount,0);
	}
	
	@Override
	public String toString() {
		return no + "|" + name + "|" + price + "|" + amount + "|" + wide;
	}

	public int getWide() {
		return wide;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}

}
