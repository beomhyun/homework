package com.ssafy.edu.hw11;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product product) throws DuplicateException;
	ArrayList<Product> findAll();
	Product findByNo(String no) throws CodeNotFoundException;
	ArrayList<Product> findByName(String name);
	ArrayList<TV> findOnlyTV();
	ArrayList<Refrigerator> findOnlyRefrigerators();
	ArrayList<Refrigerator> findByAboveRefrigerator(int capacity) throws ProductNotFoundException;
	ArrayList<TV> findByAboveTV(int wide)throws ProductNotFoundException;
	
	void updateProduct(String no, int price);
	void deleteProduct(String no);
	
	long TotalPrice();
	
	ArrayList<Product> open(String fname);
	void save(String fname, ArrayList<Product> pts);
}
