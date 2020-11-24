package collection;
import java.sql.*;
public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{ 
		    Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sellerdb?useSSL=false","root","");
		    
		  /*  PreparedStatement seller,shoplog,shop,product,order;
		    
		    seller=con.prepareStatement("create table if not exists seller(id INTEGER PRIMARY KEY,password VARCHAR(60)");
		    shoplog=con.prepareStatement("create table if not exists shoplog(sid INTEGER PRIMARY KEY,passwords VARCHAR(60))");
		    shop=con.prepareStatement("create table if not exists shop(sid INTEGER PRIMARY KEY,sname VARCHAR(60),address VARCHAR(60), mobile VARCHAR(10),email VARCHAR(60))");
		    product=con.prepareStatement("create table if not exists product(pid INTEGER PRIMARY KEY,pname VARCHAR(40),price INTEGER");
		    order=con.prepareStatement("create table if not exists order(sid INTEGER ,sname VARCHAR(40),pid INTEGER,pname VARCHAR(40),Quantity INTEGER,FOREIGN KEY (sid) REFERENCES shop(sid),FOREIGN KEY (sname) REFERENCES shop(sname),FOREIGN KEY (pid) REFERENCES product(pid),FOREIGN KEY (pname) REFERENCES product(pid)");
		    seller.execute();
		    shoplog.execute();
		    shop.execute();
		    product.execute();
		    order.execute();*/
	    }catch(Exception e){ System.out.println(e);}
		return con;
	}
}
