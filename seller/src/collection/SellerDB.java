package collection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SellerDB {

	public static int login(int id, String password) {
		// TODO Auto-generated method stub
		
		int status= 0;
		String pass=null;
		try {
			Connection con=DB.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select password from seller where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				pass=rs.getString("password");
			
			if(pass.equals(password))
				status=1;
		}
			catch(Exception e) {System.out.println(e);}
		return status;
		
	}

}
