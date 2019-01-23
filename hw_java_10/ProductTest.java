package com.ssafy.edu.hw9;

public class ProductTest {

	public static void main(String[] args) {
		ProductManagerImpl productMgr = ProductManagerImpl.getInstance();
		productMgr.open();
		productMgr.print();
		
		try {
			productMgr.add(new TV("003","samsungABC",13000,85,0));
			productMgr.findByNo("003");
			productMgr.add(new TV("003","samsungABC",13000,85,0));
			productMgr.findByAboveTV(50);
			productMgr.findByAboveRefrigerator(400);
			
		} catch (DuplicateException e) {
			System.out.println(e);
		} catch (CodeNotFoundException e) {
			System.out.println(e);
		} catch (ProductNotFoundException e) {
			System.out.println(e);
		}
		
		productMgr.save();
		productMgr.print();
	}
}
