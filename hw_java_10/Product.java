package com.ssafy.edu.hw9;

public class Product {
	protected String no;
	protected String name;
	protected int price ;
	protected int amount;
	public Product() {
		super();
	}
	public Product(String no, String name, int price, int amount) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;
		if(this.no.equals(other.getNo())) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
