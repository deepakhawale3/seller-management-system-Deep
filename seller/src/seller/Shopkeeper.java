package seller;
import collection.AddDB;
import collection.DB;
import collection.DeleteDB;
import collection.UpdateDB;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.*;
public class Shopkeeper {
	JFrame frame;
	static Shopkeeper Shopkeeper;
	private JTable table;
	private JTextField idf;
	private JTextField namef;
	private JTextField addressf;
	private JTextField mobilef;
	private JTextField passwordf;
	private JTextField emailf;
	private JTextField uid;
	private JTextField uname;
	private JTextField uaddress;
	private JTextField umobile;
	private JTextField uemail;
	private JTextField did;
	
	
	
	
	public Shopkeeper() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(46, 139, 87));
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setForeground(new Color(218, 112, 214));
		frame.setTitle("Shopkeeper,s Detail panel");
		frame.setBounds(100, 100, 718, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 702, 550);
		frame.getContentPane().add(tabbedPane);
		
		
		
		
		
		////////// Add Shopkeepers///////////
		
		
		
		
		
		JDesktopPane addshop = new JDesktopPane();
		addshop.setBackground(Color.WHITE);
		tabbedPane.addTab("Add Shopkepper", null, addshop, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		addshop.setBackground(Color.cyan);
		idf = new JTextField();
		idf.setBackground(Color.WHITE);
		idf.setBounds(303, 21, 178, 35);
		addshop.add(idf);
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
		
		idf.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (idf.getText().length() == 8) {
	                e.consume();
	            }
	        }
	    });
		
		JLabel id = new JLabel("Enter ID");
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBounds(141, 19, 118, 35);
		addshop.add(id);
		
		JLabel name = new JLabel("Enter Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(141, 65, 118, 35);
		addshop.add(name);
		
		namef = new JTextField();
		namef.setColumns(10);
		namef.setBackground(Color.WHITE);
		namef.setBounds(303, 67, 178, 35);
		addshop.add(namef);
		
		JLabel address = new JLabel("Address");
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setBounds(141, 111, 118, 35);
		addshop.add(address);
		
		addressf = new JTextField();
		addressf.setColumns(10);
		addressf.setBackground(Color.WHITE);
		addressf.setBounds(303, 113, 178, 35);
		addshop.add(addressf);
		
		JLabel mobile = new JLabel("Contact");
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobile.setBounds(141, 157, 118, 35);
		addshop.add(mobile);
		
		mobilef = new JTextField();
		mobilef.setColumns(10);
		mobilef.setBackground(Color.WHITE);
		mobilef.setBounds(303, 159, 178, 35);
		addshop.add(mobilef);
		
		mobilef.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		mobilef.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (mobilef.getText().length() == 10) {
	                e.consume();
	            }
	        }
	    });
		
		
		final JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(141, 391, 340, 23);
		addshop.add(label);
		
		JLabel email = new JLabel("email ID");
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setBounds(141, 203, 118, 35);
		addshop.add(email);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(141, 249, 118, 35);
		addshop.add(password);
		
		emailf = new JTextField();
		emailf.setColumns(10);
		emailf.setBackground(Color.WHITE);
		emailf.setBounds(303, 205, 178, 35);
		addshop.add(emailf);
		
		passwordf = new JTextField();
		passwordf.setColumns(10);
		passwordf.setBackground(Color.WHITE);
		passwordf.setBounds(303, 251, 178, 35);
		addshop.add(passwordf);
		
		JButton add = new JButton("Submit");
		add.setBounds(234, 333, 130, 47);
		addshop.add(add);
		
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				int sid = Integer.parseInt(idf.getText());
				String sname=namef.getText();
				String address=addressf.getText();
				String mobile=mobilef.getText();
				String email=emailf.getText();
				String password=passwordf.getText();
				
				if(AddDB.save(sid, sname, address, mobile,email) == 0 && AddDB.savepass(sid, password) == 0) {
					label.setText("Shopkeeper Added successfully!");
					clear();
				}else {
					label.setText("Shopkeeper adding failed!");
				}
				
				}
			public void clear() {
				idf.setText(null);
				namef.setText(null);
				addressf.setText(null);
				mobilef.setText(null);
				emailf.setText(null);
				passwordf.setText(null);
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
		addshop.add(btnBack);
		
		
		//////////////// Delete Shopkeeper/////////
		
		
		JDesktopPane delete = new JDesktopPane();
		delete.setBackground(Color.WHITE);
		tabbedPane.addTab("Delete Shopkeeper", null, delete, null);
		delete.setBackground(Color.cyan);
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
		
		did.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (did.getText().length() == 8) {
	                e.consume();
	            }
	        }
	    });
		
		JLabel lblNewLabel = new JLabel("Enter id to delete");
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
				
				if(DeleteDB.shop(sid) == 0) {
					label_1.setText("Shopkeeper deleted successfully!");
				}
				else
				
				
					label_1.setText("Shopkeeper does not exists!");
				
				
				
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
		
		
		///////////// Update Shopkeeper//////////////
		
		
		JDesktopPane Updatepane = new JDesktopPane();
		Updatepane.setBackground(Color.WHITE);
		tabbedPane.addTab("Update Shopkeeper", null, Updatepane, null);
		Updatepane.setBackground(Color.cyan);
		
		
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
		uid.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (uid.getText().length() == 10) {
	                e.consume();
	            }
	        }
	    });
		
		
		JLabel label_2 = new JLabel("Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(153, 72, 118, 35);
		Updatepane.add(label_2);
		uname = new JTextField();
		uname.setEnabled(false);
		uname.setColumns(10);
		uname.setBackground(Color.WHITE);
		uname.setBounds(315, 74, 178, 35);
		Updatepane.add(uname);
		
		
		JLabel label_4 = new JLabel("Address");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(153, 118, 118, 35);
		Updatepane.add(label_4);
		
		uaddress = new JTextField();
		uaddress.setEnabled(false);
		uaddress.setColumns(10);
		uaddress.setBackground(Color.WHITE);
		uaddress.setBounds(315, 120, 178, 35);
		Updatepane.add(uaddress);
		
		umobile = new JTextField();
		umobile.setEnabled(false);
		umobile.setColumns(10);
		umobile.setBackground(Color.WHITE);
		umobile.setBounds(315, 166, 178, 35);
		Updatepane.add(umobile);
		
		umobile.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		umobile.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (umobile.getText().length() == 10) {
	                e.consume();
	            }
	        }
	    });
		
		uemail = new JTextField();
		uemail.setEnabled(false);
		uemail.setColumns(10);
		uemail.setBackground(Color.WHITE);
		uemail.setBounds(315, 212, 178, 35);
		Updatepane.add(uemail);
		
		
		
		JLabel label_6 = new JLabel("email");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(153, 210, 118, 35);
		Updatepane.add(label_6);
		
		JLabel label_7 = new JLabel("Contact");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(153, 164, 118, 35);
		Updatepane.add(label_7);
		
		final JLabel label_3 = new JLabel("");
		label_3.setBounds(119, 398, 408, 27);
		Updatepane.add(label_3);
		
		final JLabel label_3a = new JLabel("");
		label_3a.setBounds(500, 198, 408, 27);
		Updatepane.add(label_3a);
		
		
		JButton check = new JButton("Check");
		check.setBounds(500, 25, 100, 47);
		Updatepane.add(check);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				int sid = Integer.parseInt(uid.getText());
				
				try {
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select sname,address,mobile,email from shop where sid = '" + sid + "'");
					ResultSet rs=ps.executeQuery();
					rs.next();
					if(rs != null) {
							uname.setText(rs.getString("sname"));
							uaddress.setText(rs.getString("address"));
							umobile.setText(rs.getString("mobile"));
							uemail.setText(rs.getString("email"));
							
							uname.setEnabled(true);
							uaddress.setEnabled(true);
							umobile.setEnabled(true);
							uemail.setEnabled(true);
						

							
					}
				}catch(Exception e) {
					label_3.setText("Shopkeeper does not exists!");
					uname.setEnabled(false);
					uaddress.setEnabled(false);
					umobile.setEnabled(false);
					uemail.setEnabled(false);
				
				
				}	

			}
			
		});
		
		JButton update = new JButton("Update");
		update.setBounds(246, 340, 130, 47);
		Updatepane.add(update);
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(uid.getText());				
					String nm = uname.getText();
					String addr = uaddress.getText();
					String cont=umobile.getText();
					String email = uemail.getText();
					
					if(UpdateDB.save(id,nm, addr, cont,email)  == 0 ) {
						label_3.setText("Shopkeeper updated successfully!");
					}
				
				else
					label_3.setText("Shopkeeper  not Updated!");
				clear();
			}
			public void clear() {
				uid.setText(null);
				uname.setText(null);
				uaddress.setText(null);
				umobile.setText(null);
				uemail.setText(null);
			
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
		
		
		
		///////////  View all Shopkeeper///////////////
		
		
		final JDesktopPane shopkeepers = new JDesktopPane();
		shopkeepers.setBackground(Color.WHITE);
		tabbedPane.addTab("All shopkeepers", null, shopkeepers, null);
		shopkeepers.setBackground(Color.cyan);
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[][]=null;
				String column[]=null;
				try{
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select * from shop",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
				shopkeepers.add(sp);
			}
		});
		btnDisplay.setBounds(10, 11, 89, 23);
		shopkeepers.add(btnDisplay);
		
		JButton btnBack4 = new JButton("Back");
		btnBack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Sellerchoice();
				frame.setVisible(false);
			}
		});
		btnBack4.setBounds(0, 413, 89, 23);
		shopkeepers.add(btnBack4);
		
		
	}
}
