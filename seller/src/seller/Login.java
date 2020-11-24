package seller;
import collection.SellerDB;
import shopkeeper.Loginshop;

import javax.swing.*;

import Threads.MultiThreading;

import java.awt.*;
import java.awt.event.*;

public class Login {
	static JTextField idf;
	 JLabel l1, l2, l3;
	JLabel l4;
	 
	 JButton login1,cancel;
	 JPasswordField passwordf;
	 
	 static MultiThreading m;
		static Login log_in;
		Login()
	{
		 JFrame login = new JFrame("Login Form For Seller");
		 login.setBounds(100, 100, 600, 300);

		  l1 = new JLabel("::Login Form for Seller::");
		  l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		  l1.setForeground(Color.white);
		  login.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\login.jpg")));
		  
		 
		  l2 = new JLabel("Enter ID");
		  l2.setForeground(Color.white);
		  l3 = new JLabel("Enter Password");
		  l3.setForeground(Color.white);
		  l4 =new JLabel("Invalid Details..... please Try again");
		  l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		  l4.setForeground(Color.red);
		  idf = new JTextField();
		  passwordf = new JPasswordField();
		  
		  
		  Icon Icon1 = new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\login1.jpeg");
		  login1 = new JButton(Icon1);
		  
		  Icon Icon2 = new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\cancel1.jpeg");
		  cancel = new JButton(Icon2);
		 
		  l1.setBounds(100, 30, 400, 30);
		  l2.setBounds(80, 70, 200, 30);
		  l3.setBounds(80, 110, 200, 30);
		  l4.setBounds(100, 30, 400, 30);
		  idf.setBounds(300, 70, 200, 30);
		  passwordf.setBounds(300, 110, 200, 30);
		  login1.setBounds(150, 160, 100, 30);
		  cancel.setBounds(310, 160, 100, 30);
		  
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
		  
		  login.add(l1);
		  login.add(l2);
		  login.add(idf);
		  login.add(l3);
		  login.add(passwordf);
		  login.add(login1);
		  login.add(l4);
		  login.add(cancel);
		  login.setSize(600, 300);
		  login.setLayout(null);
		  login.setVisible(true);
		  
		
		
		
	
		login1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(idf.getText());
				String pass = passwordf.getText();
				
				if(SellerDB.login(id, pass)  == 1)
				{
					
					login.setVisible(false);
				Sellerchoice	 ss= new Sellerchoice();
				}
				else
				{
					login.setVisible(true);
					l4.setVisible(true);
					l1.setVisible(false);
					
				}
			}
				
			
		});
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}	
		});
		
		
		
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	l4.setVisible(false);

	            }
	        });
	
	
	}
	
	

}
