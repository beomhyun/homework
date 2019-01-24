package com.ssafy.edu.hw11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProductManagerImpl implements IProductMgr{
	private static ProductManagerImpl productImpl;
	private ProductManagerImpl() {
	}
	public static ProductManagerImpl getInstance() {
		if(productImpl==null) {
			productImpl=new ProductManagerImpl();
		}
		return productImpl;
	}
	private ArrayList<Product> products=new ArrayList<>();

	@Override
	public void add(Product product) throws DuplicateException {
		if(products.contains(product)) {
			throw new DuplicateException();
		}else {
			products.add(product);
		}
	}

	@Override
	public ArrayList<Product> findAll() {
		ArrayList<Product> products2 = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i)!=null) {
				products2.add(products.get(i));
			}
		}
		return products2;

	}

	@Override
	public Product findByNo(String no) throws CodeNotFoundException {
		Product p = new Product();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getNo() == no) {
				p = products.get(i);
			}else {
				throw new CodeNotFoundException();
			}
		}
		return p;
	}

	@Override
	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> p = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(name)) {
				p.add(products.get(i));
			}
		}
		return p;
	}

	@Override
	public ArrayList<TV> findOnlyTV() {
		ArrayList<TV> t = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV) {
				t.add((TV)products.get(i));
			}
		}
		return t;
	}

	@Override
	public ArrayList<Refrigerator> findOnlyRefrigerators() {
		ArrayList<Refrigerator> t = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				t.add((Refrigerator)products.get(i));
			}
		}
		return t;
	}

	@Override
	public ArrayList<Refrigerator> findByAboveRefrigerator(int capacity) throws ProductNotFoundException {
		ArrayList<Refrigerator> t = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if((products.get(i) instanceof Refrigerator) &&((Refrigerator)products.get(i)).getCapacity() >= capacity) {
				t.add((Refrigerator)products.get(i));
			}
		}
		if(t==null) {
			throw new ProductNotFoundException();
		}
		return t;

	}

	@Override
	public ArrayList<TV> findByAboveTV(int wide) throws ProductNotFoundException {
		ArrayList<TV> t = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if((products.get(i) instanceof TV) &&((TV)products.get(i)).getWide() >=wide) {
				t.add((TV)products.get(i));
			}
		}
		if(t==null) {
			throw new ProductNotFoundException();
		}
		return t;

	}

	@Override
	public void updateProduct(String no, int price) {
		try {
			findByNo(no).setPrice(price);
		} catch (CodeNotFoundException e) {
			System.out.println(e);
		}		
	}

	@Override
	public void deleteProduct(String no) {
		try {
			products.remove(findByNo(no));
		} catch (CodeNotFoundException e) {
			System.out.println(e);
		}

	}

	@Override
	public long TotalPrice() {
		long total =0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice()*products.get(i).getAmount();
		}
		return total;

	}

	@Override
	public ArrayList<Product> open(String fname) {
		ArrayList<Product> pts = new ArrayList<>();
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			int count = ois.readInt();
			for(int i =0; i<count; i++) {
				int k =ois.readInt();
				Product p = (Product) ois.readObject();
				pts.add(p);
//				if(ois.readObject() instanceof TV) {
//					TV tv = (TV) ois.readObject();
//					pts.add(tv);
//				}else {
//					Refrigerator re = (Refrigerator) ois.readObject();
//					pts.add(re);
//				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return pts;
	}

	@Override
	public void save(String fname, ArrayList<Product> pts) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		int count = pts.size();
		try {
			fos = new FileOutputStream(fname,false);
			oos = new ObjectOutputStream(fos);
			oos.writeInt(count);
			int k =0;
			for(Product p : pts) {
				oos.writeInt(k++);
				oos.writeObject(p);
			}
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			//열었을떄랑 역순으로 닫아야 한다.!
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}
	public void print() {
		for(Product p : products) {
			System.out.println(p);
		}
	}
}
