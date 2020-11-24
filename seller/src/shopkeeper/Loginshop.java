package shopkeeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Threads.MultiThreading;
import collection.ShoplogDB;


public class Loginshop {
	
	static JTextField idf;
	 JLabel l1, l2, l3,l4;
	 
	 JButton login1 , cancel;
	 JPasswordField passwordf;
	 
	 static MultiThreading m;
		static Loginshop log_in;
	Loginshop()
	{
		 JFrame login = new JFrame("Login Form for Shopkeeper");
		 login.setBounds(100, 100, 600, 300);
		 login.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\login.jpg")));	
		 l1 = new JLabel("::  Login Form for Shopkeeper  ::");
		 l1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		  l1.setForeground(Color.blue);
		 
		  //login.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\Desktop\\pro pic\\seller.jpeg")));
		  l2 = new JLabel("Enter ID");
		  l2.setForeground(Color.white);
		  l3 = new JLabel("Enter Password");
		  l3.setForeground(Color.white);
		  l4 =new JLabel("Invalid Details..... please Try again");
		  l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		  l4.setForeground(Color.red);
		  idf = new JTextField();
		  passwordf = new JPasswordField();


		  idf = new JTextField();
		  passwordf = new JPasswordField();
		  
		  Icon warnIcon = new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\login1.jpeg");
		  login1 = new JButton(warnIcon);
		  
		  Icon warnIcon2 = new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\cancel1.jpeg");
		  cancel = new JButton(warnIcon2);
		  
		  l1.setBounds(100, 30, 400, 30);
		  l2.setBounds(80, 70, 200, 30);
		  l3.setBounds(80, 110, 200, 30);
		  l4.setBounds(100, 30, 400, 30);

		  idf.setBounds(300, 70, 200, 30);
		  passwordf.setBounds(300, 110, 200, 30);
		  login1.setBounds(150, 160, 100, 30);
		  cancel.setBounds(270, 160, 100, 30);
		  login.add(l1);
		  login.add(l2);
		  login.add(idf);
		  login.add(l3);
		  login.add(passwordf);
		  login.add(login1);
		  login.add(l4);
		  login.add(cancel);
		  login.setLayout(null);
		  login.setVisible(true);
		
		
		
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
		
	
		login1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(idf.getText());
				@SuppressWarnings("deprecation")
				String pass = passwordf.getText();
				
				if(ShoplogDB.login(id, pass)  == 1)
				{
					
					login.setVisible(false);
				 new Shopchoice();
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
	
	private void setContentPane(JLabel jLabel) {
		// TODO Auto-generated method stub
		
	}

	

	public static String getID() {
		// TODO Auto-generated method stub
		
		return idf.getText();
	}

}
