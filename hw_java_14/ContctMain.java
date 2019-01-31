package phonbook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ContctMain implements ActionListener, ItemListener{
	CustomerDAO dao = new CustomerDAO();
	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAdresss;
	private JButton btnInsert;
	private JButton btnSearch;
	private JButton btnUpload;
	private JButton btnClear;
	private JButton btnExit;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JList list;
	private JLabel status;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		new ContctMain();
	}

	/**
	 * Create the application.
	 */
	public ContctMain() {
		initialize();
		dao = new CustomerDAO();
		showList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		list = new JList();
		list.setBounds(0, 28, 434, 108);
		frame.getContentPane().add(list);
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(this);
		btnInsert.setBounds(27, 180, 77, 23);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(115, 180, 79, 23);
		frame.getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(206, 180, 96, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(314, 182, 96, 23);
		frame.getContentPane().add(btnSearch);
		
		JLabel label_name = new JLabel("이   름");
		label_name.setBounds(90, 213, 57, 15);
		frame.getContentPane().add(label_name);
		
		JLabel label_phone = new JLabel("핸드폰");
		label_phone.setBounds(90, 238, 57, 15);
		frame.getContentPane().add(label_phone);
		
		JLabel label_adress = new JLabel("주   소");
		label_adress.setBounds(90, 263, 57, 15);
		frame.getContentPane().add(label_adress);
		
		textName = new JTextField();
		textName.setBounds(202, 210, 186, 21);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(202, 235, 186, 21);
		frame.getContentPane().add(textPhone);
		
		textAdresss = new JTextField();
		textAdresss.setColumns(10);
		textAdresss.setBounds(202, 260, 186, 21);
		frame.getContentPane().add(textAdresss);
		
		btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(this);
		btnUpload.setBounds(71, 291, 97, 23);
		frame.getContentPane().add(btnUpload);

		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(this);
		btnClear.setBounds(181, 291, 97, 23);
		frame.getContentPane().add(btnClear);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(this);
		btnExit.setBounds(291, 291, 97, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("PHON BOOK");
		lblNewLabel.setBounds(166, 3, 186, 15);
		frame.getContentPane().add(lblNewLabel);
		
		status = new JLabel("");
		status.setBounds(44, 146, 347, 24);
		frame.getContentPane().add(status);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//int index = list.getSelectedIndex();
				Customer cu = (Customer) list.getSelectedValue();
				textName.setText(cu.getName());
				textPhone.setText(cu.getPhone());
				textAdresss.setText(cu.getAdress());
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
							System.exit(0);
			} 
		});
		frame.setVisible(true);
	}
//Jlist의 항목이 선택(클릭)되어 ItemEvent가 발생했을때 실행.
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	public void insert() {
		String name = textName.getText().trim();
		String phone = textPhone.getText().trim();
		String adress = textAdresss.getText().trim();
		if(name.equals("")||phone.equals("")||adress.equals("")){
			status.setText("비어있는 항목이 있습니다.");
			return;
		}
		try {
			dao.addcust(name, phone, adress);
			showList();
			clearText();
		} catch (ExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete() {
		String name = textName.getText().trim();
		if(name.equals("")) {
			status.setText("삭제하려는 이름을 먼저 입력해 주세요.");
			return;
		}
		try {
			dao.delete(name);
			showList();
			clearText();
		} catch (NotFoundException e) {
		}
	}
	public void update() {
		String name = textName.getText().trim();
		String phone = textPhone.getText().trim();
		String adress = textAdresss.getText().trim();
		if(name.equals("")||phone.equals("")||adress.equals("")){
			status.setText("비어있는 항목이 있습니다.");
			return;
		}
		try {
			dao.updateCust(name, phone, adress);
			showList();
			clearText();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void upload() {
		dao.upload();
		clearText();
	}

	public void search() {
		Customer c = null;
		if(textName.getText().equals("")) {
			return;
		}
		String name = textName.getText().trim();
		if(!name.equals("")) {
			try {
				c = dao.search(name);
				textPhone.setText(c.getPhone());
				textAdresss.setText(c.getAdress());
			} catch (NotFoundException e) {
			}
		}else {
			status.setText("이름을 먼저 입력하세요.");
		}
	}
	public void exit() {
		System.out.println("bye~");
		try {
			dao.close();
		} catch (Exception e) {
		}
		System.exit(0);
		
	}
	public void showList() {
		List<Customer> cust = dao.allcust();
		list.removeAll();
		if(cust!=null) {
			System.out.println(cust);
			list.setListData(cust.toArray());
		}
	}
	public void clearText() {
		textAdresss.setText("");
		textName.setText("");
		textPhone.setText("");
		status.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSearch) {
			search();
		}else if(e.getSource() == btnUpload) {
			upload();
		}else if(e.getSource() == btnInsert) {
			insert();
		}else if(e.getSource() == btnClear) {
			clearText();
		}else if(e.getSource() == btnUpdate) {
			update();
		}else if(e.getSource() == btnDelete) {
			delete();
		}else {
			exit();
		}
		
	}
}
