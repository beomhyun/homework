package com.ssafy.edu.hw9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	public void open() {
		String fname = "product.txt";
		BufferedReader br =null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg = "";
			while((msg=br.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(msg,"|");
				int kind = Integer.parseInt(st.nextToken().trim());
				//1|001|samsung001|10000|95|60
//				protected String no;
//				protected String name;
//				protected int price ;
//				protected int amount;
				if(kind == 1) {
					products.add(new TV(
							st.nextToken().trim(),
							st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}else {
					products.add(new Refrigerator(
							st.nextToken().trim(),
							st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void save() {
		String fname = "product.txt";
		PrintWriter pw =null;
		try {
			pw =new PrintWriter(new FileWriter(fname,false),true);
			for (int i = 0; i < products.size(); i++) {
				if(products.get(i) instanceof TV) {
					TV tv = (TV) products.get(i);
					String str ="1|";
					str = str+tv;
					pw.println(str);
				}else {
					Refrigerator re = (Refrigerator) products.get(i);
					String str = "2|";
					str = str+re;
					pw.println(str);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			pw.close();
		}
	}
	public void print() {
		for(Product p : products) {
			System.out.println(p);
		}
	}
}
