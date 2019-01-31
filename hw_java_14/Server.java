package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import phonbook.Customer;

public class Server   {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(5525);
		Socket s = null;
		ObjectInputStream ois = null;
		Customer cu = null;
		
		while(true) {
			s =ss.accept();
			ois = new ObjectInputStream(s.getInputStream());
			try {
				while(true) {
					cu = (Customer) ois.readObject();
					if(cu==null) break;
					System.out.println(cu);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}finally {
				ois.close();
				s.close();
			}
			
		}
	}
	
	
	
	
	
	
	
}
