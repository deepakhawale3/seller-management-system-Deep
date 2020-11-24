package collection;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class ProductDB {

		public static int add(int id, String name, int price) {
			
			// TODO Auto-generated method stub
			int status =0;
			try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into product (pid, pname, price) values(?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3,price);
			
			if(ps.execute())
				status=1;
				System.out.println(status);
			}
			catch(Exception f) {System.out.println(f);}
			return status;
			
	
}
}
