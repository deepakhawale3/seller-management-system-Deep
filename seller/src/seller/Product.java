package seller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import collection.DB;
import collection.DeleteDB;
import collection.ProductDB;
import collection.UpdateDB;

public class Product {

	JFrame frame;
	static Product Product;
	private JTable table;
	private JTextField idf;
	private JTextField namef;
	private JTextField pricef;
	private JTextField uid;
	private JTextField uname;
	private JTextField uprice;
	private JTextField did;
	
	
	
	
	
	public 	Product() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(46, 139, 87));
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setForeground(new Color(218, 112, 214));
		frame.setTitle("Products Detail panel");
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\product.jpg")));
		frame.setBounds(100, 100, 718, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 702, 550);
		frame.getContentPane().add(tabbedPane);
		
		
		
		//////////// Add product //////////////
		
		JDesktopPane addpro = new JDesktopPane();
		addpro.setBackground(Color.WHITE);
		tabbedPane.addTab("Add Products", null, addpro, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		addpro.setBackground(Color.orange);
		idf = new JTextField();
		idf.setBackground(Color.WHITE);
		idf.setBounds(303, 21, 178, 35);
		addpro.add(idf);
		idf.setColumns(10);
		
		idf.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		
		
		JLabel id = new JLabel("Enter ID");
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBounds(141, 19, 118, 35);
		addpro.add(id);
		
		JLabel name = new JLabel("Enter Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(141, 65, 118, 35);
		addpro.add(name);
		
		namef = new JTextField();
		namef.setColumns(10);
		namef.setBackground(Color.WHITE);
		namef.setBounds(303, 67, 178, 35);
		addpro.add(namef);
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		price.setBounds(141, 111, 118, 35);
		addpro.add(price);
		
		pricef = new JTextField();
		pricef.setColumns(10);
		pricef.setBackground(Color.WHITE);
		pricef.setBounds(303, 113, 178, 35);
		addpro.add(pricef);
		
		
		pricef.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		final JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(141, 391, 340, 23);
		addpro.add(label);
		
		JButton add = new JButton("Submit");
		add.setBounds(234, 233, 130, 47);
		addpro.add(add);
		
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				
				
				int id = Integer.parseInt(idf.getText());
				String name=namef.getText();
				int price = Integer.parseInt(pricef.getText());
				
				if(ProductDB.add(id, name, price) == 0) {
					label.setText("Product Added successfully!");
					clear();
					
				}else {
					label.setText("Product adding failed !");
				}
				
				}
			public void clear() {
				idf.setText(null);
				namef.setText(null);
				pricef.setText(null);
			}
			    });
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sellerchoice();
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 413, 89, 23);
		addpro.add(btnBack);
		
		
		/////////////// Delete Product ///////////
		
		
		JDesktopPane delete = new JDesktopPane();
		delete.setBackground(Color.WHITE);
		tabbedPane.addTab("Delete Product", null, delete, null);
		delete.setBackground(Color.orange);
		did = new JTextField();
		did.setBounds(232, 37, 177, 42);
		delete.add(did);
		did.setColumns(10);
		
		did.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		JLabel lblNewLabel = new JLabel("Enter Product id:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(68, 44, 154, 28);
		delete.add(lblNewLabel);
		
		JLabel lblNew = new JLabel("It accepts numbers only");
		lblNew.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNew.setBounds(200, 80, 154, 28);
		delete.add(lblNew);
		
		final JLabel label_1 = new JLabel("");
		label_1.setBounds(68, 168, 372, 48);
		delete.add(label_1);
		
		JButton del = new JButton("Delete");
		del.setBounds(174, 109, 100, 36);
		delete.add(del);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sid = Integer.parseInt(did.getText());
				
				if(DeleteDB.deletepro(sid) == 0) {
					label_1.setText("Product deleted successfully!");
				}
				else
				
				
					label_1.setText("Product does not exists!");
				
				
				
			clear();
			}
			public void clear() {
				did.setText(null);
			}
		});
		
		
		JButton btnBack2 = new JButton("Back");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sellerchoice();
			
				frame.setVisible(false);
			}
		});
		btnBack2.setBounds(0, 413, 89, 23);
		delete.add(btnBack2);
		
		/////////// Update Pro ///////////////////////
		
		
		
		JDesktopPane Updatepane = new JDesktopPane();
		Updatepane.setBackground(Color.WHITE);
		tabbedPane.addTab("Update Product", null, Updatepane, null);
		Updatepane.setBackground(Color.orange);
		JLabel label_2 = new JLabel("Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(153, 72, 118, 35);
		Updatepane.add(label_2);
		
		JLabel lblEnterIdTo = new JLabel("Enter id to update");
		lblEnterIdTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterIdTo.setBounds(153, 26, 130, 35);
		Updatepane.add(lblEnterIdTo);
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBackground(Color.WHITE);
		uid.setBounds(315, 28, 178, 35);
		Updatepane.add(uid);
		
		uid.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		uname = new JTextField();
		uname.setEnabled(false);
		uname.setColumns(10);
		uname.setBackground(Color.WHITE);
		uname.setBounds(315, 74, 178, 35);
		Updatepane.add(uname);
		
		JLabel label_4 = new JLabel("Price");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(153, 118, 118, 35);
		Updatepane.add(label_4);
		
		uprice = new JTextField();
		uprice.setEnabled(false);
		uprice.setColumns(10);
		uprice.setBackground(Color.WHITE);
		uprice.setBounds(315, 120, 178, 35);
		Updatepane.add(uprice);
		
		uprice.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		final JLabel label_3 = new JLabel("");
		label_3.setBounds(119, 398, 408, 27);
		Updatepane.add(label_3);
		
		JButton check = new JButton("Check");
		check.setBounds(500, 25, 100, 47);
		Updatepane.add(check);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				int sid = Integer.parseInt(uid.getText());
				
				try {
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select pname,price from product where pid = '" + sid + "'");
					ResultSet rs=ps.executeQuery();
					rs.next();
					if(rs != null) {
							uname.setText(rs.getString("pname"));
							uprice.setText(rs.getString("price"));
							
							
							uname.setEnabled(true);
							uprice.setEnabled(true);
							
						

							
					}
				}catch(Exception e) {
					label_3.setText("Product does not exists!");
					uname.setEnabled(false);
					uprice.setEnabled(false);
				
					
				}	
				
			}
			
		});
		
		JButton update = new JButton("Update");
		update.setBounds(246, 240, 130, 47);
		Updatepane.add(update);
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(uid.getText());				
					String nm = uname.getText();
					int price = Integer.parseInt(uprice.getText());
				
					
					if(UpdateDB.savepro(id,nm, price)  == 0 ) {
						label_3.setText("product details updated successfully!");
					}
				
				else
					label_3.setText("product  not Updated!");
				clear();
			}
			public void clear() {
				uid.setText(null);
				uname.setText(null);
				uprice.setText(null);
				
			
			}
		});
		
		
		
		
		JButton btnBack3 = new JButton("Back");
		btnBack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sellerchoice();
				frame.setVisible(false);
			}
		});
		btnBack3.setBounds(0, 413, 89, 23);
		Updatepane.add(btnBack3);
		
		
		/////////// View All products ////////////////
		
		final JDesktopPane products = new JDesktopPane();
		products.setBackground(Color.WHITE);
		tabbedPane.addTab("All Products", null, products, null);
		products.setBackground(Color.orange);
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
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
		btnDisplay.setBounds(10, 11, 89, 23);
		products.add(btnDisplay);
		
		JButton btnBack4 = new JButton("Back");
		btnBack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Sellerchoice();
				frame.setVisible(false);
			}
		});
		btnBack4.setBounds(0, 413, 89, 23);
		products.add(btnBack4);
		
	}
	
}
