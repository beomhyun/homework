package phonbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	List<Customer> list;
	public CustomerDAO() {
		list = new ArrayList<>();
		open();
	}
	public void open() {
		ObjectInputStream ois =null;
		File file = new File("cust.dat");
		if(!file.exists()) {return;}
		list.clear();
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			Customer cu = null;
			while(true) {
				cu = (Customer) ois.readObject();
				System.out.println(cu);
				System.out.println("hi");
				list.add(cu);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}finally {
			if(ois!=null)
				try {
					ois.close();
				} catch (IOException e) {
				}
		}
	}
	
	public void close() throws Exception {
		File file =new File("cust.txt");

			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Customer cu : list) {
				oos.writeObject(cu);
				System.out.println(cu);
			}
			oos.close();
			fos.close();
	}
	
	//추가
	public void addcust(String name, String phone, String adress) throws ExistException {
		try {
			search(name);
			throw new ExistException();
		} catch (NotFoundException e) {
			Customer cu = new Customer(name, phone, adress);
			list.add(cu);
		}
	}
	//검색
	public Customer search(String name) throws NotFoundException {

		if(list!=null) {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getName().equals(name)) {
					return list.get(i);
				}
			}
		}
		throw new NotFoundException();
	}
	//삭제
	public void delete(String name) throws NotFoundException {
		Customer cu = search(name);
		list.remove(cu);
	}
	public List<Customer> allcust(){
		return list;
	}
	
	//수정
	public void updateCust(String name, String phone, String adress) throws NotFoundException {
		Customer cu = search(name);
		cu.setAdress(adress);
		cu.setPhone(phone);
	}
	public void upload() {
		Thread t = new Thread(){
			public void run() {
				try {
					Socket s = new Socket("127.0.0.1",5525);
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					for(Customer cu : list) {
						oos.writeObject(cu);
					}
					oos.close();
					s.close();
				} catch (IOException e) {
				}
				
			}
		};
		t.start();
	}
}
