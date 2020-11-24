package collection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDB {
	
	
	public static int save(int id, String nm, String addr, String cont , String email) {
		// TODO Auto-generated method stub
		int status =0;
		try {
		Connection con=DB.getConnection();
		String s="update shop set sname= ? ,address=?,mobile=?,email=? where sid= ?";
		PreparedStatement ps=con.prepareStatement(s);
		
		
		ps.setString(1,nm);
		ps.setString(2,addr);
		ps.setString(3,cont);
		ps.setString(4,email);
		ps.setInt(5,id);
		
		
		
		if(ps.execute())
			status=1;
			System.out.println(status);
		}
		catch(Exception f) {System.out.println(f);}
		return status;
	}
	
	public static int savepro(int id, String nm, int price) {
		// TODO Auto-generated method stub
		int status =0;
		try {
		Connection con=DB.getConnection();
		String s="update product set pname= ? ,price=? where pid= ?";
		PreparedStatement ps=con.prepareStatement(s);
		
		
		ps.setString(1,nm);
		ps.setInt(2,price);
		ps.setInt(3,id);
		
		
		
		if(ps.execute())
			status=1;
			System.out.println(status);
		}
		catch(Exception f) {System.out.println(f);}
		return status;
	}
	
	
}
