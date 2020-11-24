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

import collection.DB;

public class Order {
	
	JFrame frame;
	static Order Order;
	private JTable table;
	JTextField uid;
	
	
	
	
	public 	Order() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(46, 139, 87));
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setForeground(new Color(218, 112, 214));
		frame.setTitle("Products Detail panel");
		frame.setBounds(100, 100, 718, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\order.jpg")));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 702, 550);
		frame.getContentPane().add(tabbedPane);
		
		
		
		/////////  view all orders ////////////
		
		JDesktopPane orders = new JDesktopPane();
		orders.setBackground(Color.WHITE);
		tabbedPane.addTab("All Order", null, orders, null);
		orders.setBackground(Color.YELLOW);
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[][]=null;
				String column[]=null;
				try{
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select * from `order`",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
				orders.add(sp);
			}
		});
		btnDisplay.setBounds(10, 11, 89, 23);
		orders.add(btnDisplay);
		
		JButton btnBack4 = new JButton("Back");
		btnBack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Sellerchoice();
				frame.setVisible(false);
			}
		});
		btnBack4.setBounds(0, 413, 89, 23);
		orders.add(btnBack4);
		
		
		
		////////////////   View Specific orders /////////////////////
		final JDesktopPane specific = new JDesktopPane();
		specific.setBackground(Color.WHITE);
		tabbedPane.addTab("View Specific orders", null, specific, null);
		specific.setBackground(Color.YELLOW);
		JLabel lblEnterIdTo = new JLabel("Enter id to search:");
		lblEnterIdTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterIdTo.setBounds(11, 11, 130, 35);
		specific.add(lblEnterIdTo);
		
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBackground(Color.WHITE);
		uid.setBounds(150, 11, 178, 35);
		specific.add(uid);
		
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
		
		JButton btnview = new JButton("Display");
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[][]=null;
				String column[]=null;
				try{
					int sid = Integer.parseInt(uid.getText());
					java.sql.Connection con= DB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select * from `order` where sid = '" + sid + "'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
				specific.add(sp);
			}
		});
		btnview.setBounds(350, 11,  80, 35);
		specific.add(btnview);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Sellerchoice();
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 413, 89, 23);
		specific.add(btnBack);

		
		
		
	}
	
	
}
