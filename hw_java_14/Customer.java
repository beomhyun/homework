package phonbook;

public class Customer {
	private String name;
	private String phone;
	private String adress;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Customer(String name, String phone, String adress) {
		super();
		this.name = name;
		this.phone = phone;
		this.adress = adress;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(name);
		str.append("    ");
		str.append(phone);
		str.append("    ");
		str.append(adress);
		return str.toString();
	}
	
}
