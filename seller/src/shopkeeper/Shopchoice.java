package shopkeeper;
import javax.swing.*;

import seller.Order;
import seller.Product;
import seller.Shopkeeper;

import java.awt.*;
import java.awt.event.*;
public class Shopchoice {
	JFrame frame;
	
	public Shopchoice() {
		initialize();
	}
	
	
	////////
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\order.jpg")));
		JLabel idf=new JLabel("Your ID:");
		idf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idf.setBounds(10, 19, 118, 35);
		frame.getContentPane().add(idf);
		JLabel id=new JLabel(Loginshop.getID());
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBounds(65, 19, 118, 35);
		frame.getContentPane().add(id);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				frame.dispose();
			}
		});
		logout.setBounds(152, 46, 150 , 36);
		frame.getContentPane().add(logout);
		
		
		
		JButton orderbutton = new JButton("Orders");
		orderbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ordershop();
				frame.setVisible(false);
			}
		});
		orderbutton.setBounds(152, 150, 150 , 36);
		frame.getContentPane().add(orderbutton);
		
		
		
		
		
	}
}