package shopkeeper;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import collection.DB;
import collection.OrderDB;



public class Ordershop {

	JFrame frame;
	static Ordershop Order;
	private JTable table;
	private JTextField quantityf;
	private JTextField namef;
	private JTextField totalf;
	
	
	
	public Ordershop() {
		initialize();
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(46, 139, 87));
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setForeground(new Color(218, 112, 214));
		frame.setTitle("My Order panel");
		frame.setBounds(100, 100, 718, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 702, 550);
		frame.getContentPane().add(tabbedPane);
		
		
		////////////////////////// View Orders //////////////////
		
		JDesktopPane myorder = new JDesktopPane();
		myorder.setBackground(Color.WHITE);
		tabbedPane.addTab("My orders", null, myorder, null);
		tabbedPane.setBackgroundAt(0, Color.GREEN);
		myorder.setBackground(Color.gray);
		JLabel idf=new JLabel("Your ID:");
		idf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idf.setBounds(10, 1, 118, 35);
		myorder.add(idf);
		JLabel id=new JLabel(Loginshop.getID());
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBounds(65, 1, 118, 35);
		myorder.add(id);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBounds(10, 31, 89, 23);
		myorder.add(btnDisplay);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[][]=null;
				String column[]=null;
				int spid = Integer.parseInt(id.getText());
				try{
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select pid,pname,quantity,total from `order` where sid = '" + spid + "'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=ps.executeQuery();
					
					java.sql.ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					column=new String[cols];
					for(int i=1;i<=cols;i++){
						column[i-1]=rsmd.getColumnName(i);
					}
					
					rs.last();
					int rows=rs.getRow();
					rs.beforeFirst();

					data=new String[rows][cols];
					int count=0;
					while(rs.next()){
						for(int i=1;i<=cols;i++){
							data[count][i-1]=rs.getString(i);
						}
						count++;
					}
					con.close();
				}catch(Exception e){System.out.println(e);}
				
				table = new JTable(data,column);
				//table.setBounds(10, 50, 400, 400);
				//desktopPane_4.add(table);
				JScrollPane sp=new JScrollPane(table);
				table.setEnabled(false);
				sp.setBounds(10, 60, 721, 475);
				myorder.add(sp);
			}
		});
		
		
		
		
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Shopchoice();
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 413, 89, 23);
		myorder.add(btnBack);
		
		/////////////// View all product //////////////
		
		JDesktopPane products = new JDesktopPane();
		products.setBackground(Color.WHITE);
		tabbedPane.addTab("All Products", null, products, null);
		products.setBackground(Color.gray);
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[][]=null;
				String column[]=null;
				try{
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select * from product",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs=ps.executeQuery();
					
					java.sql.ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					column=new String[cols];
					for(int i=1;i<=cols;i++){
						column[i-1]=rsmd.getColumnName(i);
					}
					
					rs.last();
					int rows=rs.getRow();
					rs.beforeFirst();

					data=new String[rows][cols];
					int count=0;
					while(rs.next()){
						for(int i=1;i<=cols;i++){
							data[count][i-1]=rs.getString(i);
						}
						count++;
					}
					con.close();
				}catch(Exception e){System.out.println(e);}
				
				table = new JTable(data,column);
				//table.setBounds(10, 50, 400, 400);
				//desktopPane_4.add(table);
				JScrollPane sp=new JScrollPane(table);
				table.setEnabled(false);
				sp.setBounds(10, 60, 721, 475);
				products.add(sp);
			}
		});
		show.setBounds(10, 11, 89, 23);
		products.add(show);
		
		JButton btnBack1 = new JButton("Back");
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Shopchoice();
				frame.setVisible(false);
			}
		});
		btnBack1.setBounds(0, 413, 89, 23);
		products.add(btnBack1);
		
		///////////////// Place order ////////////////////
		
		JDesktopPane placeorder = new JDesktopPane();
		placeorder.setBackground(Color.WHITE);
		tabbedPane.addTab("Place Order", null, placeorder, null);
		placeorder.setBackground(Color.gray);
		
		JLabel label_1 = new JLabel("Enter Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(150, 72, 118, 35);
		placeorder.add(label_1);
		
		JLabel idfd=new JLabel("Your ID:");
		idfd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idfd.setBounds(10, 1, 118, 35);
		placeorder.add(idfd);
		JLabel sid=new JLabel(Loginshop.getID());
		sid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sid.setBounds(65, 1, 118, 35);
		placeorder.add(sid);
		
		
		namef = new JTextField();
		namef.setColumns(10);
		namef.setBackground(Color.WHITE);
		namef.setBounds(300, 74, 178, 35);
		placeorder.add(namef);
		
		
		JLabel label_2 = new JLabel("Enter Quantity:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(150, 140, 118, 35);
		placeorder.add(label_2);
		
		quantityf = new JTextField();
		quantityf.setColumns(10);
		quantityf.setBackground(Color.WHITE);
		quantityf.setBounds(300, 140, 178, 35);
		placeorder.add(quantityf);
		
		quantityf.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		JLabel label_3 = new JLabel("Price:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(150, 210, 118, 35);
		placeorder.add(label_3);
		
		final JLabel	pricef = new JLabel("");
		pricef.setBounds(350, 210, 178, 35);
		placeorder.add(pricef);
		
		JLabel label_4 = new JLabel("Total:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(150, 240, 118, 35);
		placeorder.add(label_4);
		
		final JLabel	msg = new JLabel("");
		msg.setBounds(150, 320, 178, 35);
		placeorder.add(msg);
		
		final JLabel	totalf = new JLabel("");
		totalf.setBounds(350, 240, 178, 35);
		placeorder.add(totalf);
		
		JButton total = new JButton("Total");
		total.setBounds(170, 190, 89, 23);
		placeorder.add(total);
		
		total.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				try {
					String name=namef.getText();
					int q = Integer.parseInt(quantityf.getText());
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select price from product where pname = '" + name + "'");
					ResultSet rs=ps.executeQuery();
					rs.next();
					if(rs != null) {
						int x = Integer.parseInt(rs.getString("price"))*q;
						pricef.setText(rs.getString("price"));
						totalf.setText(Integer.toString(x));	
											
					}
				}catch(Exception e) {
					msg.setText("Product is not exists!");
					
				}	

			}
			
		});
		
		
		JButton place = new JButton("Place Order");
		place.setBounds(170, 300, 110, 23);
		placeorder.add(place);
		place.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int spid = Integer.parseInt(sid.getText());
				int quantity = Integer.parseInt(quantityf.getText());
				String pname=namef.getText();
				int total = Integer.parseInt(totalf.getText());
				
					if(OrderDB.save(spid, pname, quantity, total)  == 0)
						msg.setText("Order Placed successfully!");
					else
						msg.setText("Order not Placed !");
				
				
				
				clear();
			}
			public void clear() {
				namef.setText(null);
				quantityf.setText(null);
				totalf.setText(null);
				pricef.setText(null);
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		JButton btnBack2= new JButton("Back");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Shopchoice();
				frame.setVisible(false);
			}
		});
		btnBack2.setBounds(0, 413, 89, 23);
		placeorder.add(btnBack2);
		
		
		
		/////////// User Details////////
		
		
		
		
		final JDesktopPane detail = new JDesktopPane();
		detail.setBackground(Color.WHITE);
		tabbedPane.addTab("My Details", null, detail, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		detail.setBackground(Color.gray);
		JLabel idfl=new JLabel("Your ID:");
		idfl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idfl.setBounds(10, 19, 118, 35);
		detail.add(idfl);
		JLabel idl=new JLabel(Loginshop.getID());
		idl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idl.setBounds(65, 19, 118, 35);
		detail.add(idl);
		
		
		
		JLabel	name = new JLabel("Your name::");
		name.setBounds(150, 70, 118, 35);
		detail.add(name);
		
		final JLabel	namel = new JLabel("");
	
		namel.setBounds(300, 70, 178, 35);
		detail.add(namel);
		
		JLabel	address = new JLabel("Your address::");
		address.setBounds(150, 100, 118, 35);
		detail.add(address);
		
		final JLabel	addressl = new JLabel("");
		addressl.setBounds(300, 100, 178, 35);
		detail.add(addressl);
		
		JLabel	mobile = new JLabel("Your contact no::");
		mobile.setBounds(150, 130, 118, 35);
		detail.add(mobile);
		
		final JLabel	mobilef = new JLabel("");
		mobilef.setBounds(300, 130, 178, 35);
		detail.add(mobilef);
		
		JLabel	email = new JLabel("Your Email ID::");
		email.setBounds(150, 160, 118, 35);
		detail.add(email);
		
		JLabel	emailf = new JLabel("");
		emailf.setBounds(300, 160, 178, 35);
		detail.add(emailf);
		
		final JLabel	warning = new JLabel("");
		warning.setBounds(300, 160, 178, 35);
		detail.add(warning);
		
		JButton view = new JButton("View");
		view.setBounds(10, 50, 89, 23);
		detail.add(view);
		
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				int sid = Integer.parseInt(idl.getText());
				
				try {
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select * from `shop` where sid = '" + sid + "'");
					ResultSet rs=ps.executeQuery();
					rs.next();
					if(rs != null) {
							namel.setText(rs.getString("sname"));
							addressl.setText(rs.getString("address"));
							mobilef.setText(rs.getString("mobile"));
							emailf.setText(rs.getString("email"));
							
							
							
						

							
					}
				}catch(Exception e) {
					warning.setText("Ask to Your Seller!");
					
				
					
				}	

			}
			
		});
		
	
		JButton btnBack3= new JButton("Back");
		btnBack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Shopchoice();
				frame.setVisible(false);
			}
		});
		btnBack3.setBounds(0, 413, 89, 23);
		detail.add(btnBack3);
		
	}
}
