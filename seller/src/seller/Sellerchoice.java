package seller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Sellerchoice {
	JFrame frame;
	
	public Sellerchoice() {
		initialize();
	}
	
	
	////////
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hp\\eclipse-workspace\\deepswing\\seller\\pic\\product.jpg")));
		JButton shopbutton = new JButton("Shopkeepers");
		shopbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Shopkeeper s= new Shopkeeper();
				
				frame.setVisible(false);
			}
		});
		shopbutton.setBounds(152, 46, 150 , 36);
		frame.getContentPane().add(shopbutton);
		
		JButton productbutton = new JButton("Products");
		productbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Product();
				frame.setVisible(false);
			}
		});
		productbutton.setBounds(152, 129, 150 , 36);
		frame.getContentPane().add(productbutton);
		
		JButton orderbutton = new JButton("Orders");
		orderbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Order();
				frame.setVisible(false);
			}
		});
		orderbutton.setBounds(152, 212, 150 , 36);
		frame.getContentPane().add(orderbutton);
		
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				frame.setVisible(false);
			}
		});
		logout.setBounds(350, 46, 150 , 36);
		frame.getContentPane().add(logout);
		
		
		
		
	}
}
