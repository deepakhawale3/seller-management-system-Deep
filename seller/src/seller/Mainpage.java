package seller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mainpage {
	 JLabel  l2, l3;
	
	Mainpage()
	{
		 JFrame login = new JFrame("Login Form For Seller");
		 login.setBounds(0, 0, 1350, 700);
		 
		 
		 
		
		 
	
		 
		 login.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\main.jpg")));
		 JButton login1=new JButton("login");
		 login1.setBounds(900, 30, 100, 30);
		
		 
		 JButton cancel=new JButton("Close");
		 cancel.setBounds(1100, 30, 100, 30);
		 
		
		 
		 
		 
		 
		 login1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Login();
					
				}
			});
		 
		 cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					login.dispose();
					//cancel.setVisible(false);
				}
			});
		 
		 
		  JLabel l1 = new JLabel("::Seller Login Panel::");
		  l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		  l1.setForeground(Color.blue);
		  l1.setBounds(900, 100, 400, 30);
		  
		  
		  login.add(login1);
		  login.add(cancel);
		 
		 
		  login.setVisible(true);
	}

	public static void main(String[] args) {
		Mainpage m=new Mainpage();
	}
	
}
