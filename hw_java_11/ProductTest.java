package com.ssafy.edu.hw11;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		
		String fname = "Srudent.obj";		
		ProductManagerImpl productMgr = ProductManagerImpl.getInstance();
		ArrayList<Product> pp =  productMgr.open(fname);
		for(Product p : pp ) {
			System.out.println(p);
		}
		/*
		ArrayList<Product> pts = new ArrayList<>();
		pts.add(new TV("001","samsungABC",13000,85,0));
		pts.add(new TV("002","LG001",12000,75,0));
		pts.add(new Refrigerator("011","samsung011",20000,5,0));
		pts.add(new Refrigerator("021","LG021",21000,15,0));
		
		productMgr.save(fname, pts);
		*/
		
	}
}
