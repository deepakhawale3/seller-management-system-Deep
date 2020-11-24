package collection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddDB {

	public static int save(int sid, String sname, String address, String mobile, String email) {
		
		// TODO Auto-generated method stub
		int status =0;
		try {
		Connection con=DB.getConnection();
		String s="insert into shop (sid, sname ,address,mobile,email) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,sid);
		ps.setString(2,sname);
		ps.setString(3,address);
		ps.setString(4,mobile);
		ps.setString(5,email);
		//ps.setString(4,d);
		if(ps.execute())
			status=1;
			System.out.println(status);
		}
		catch(Exception f) {System.out.println(f);}
		return status;
	}

	public static int savepass(int sid, String password) {
		// TODO Auto-generated method stub
		int status =0;
		try {
		Connection con=DB.getConnection();
		String s="insert into shoplog (sid, password) values(?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,sid);
		ps.setString(2,password);
		
		//ps.setString(4,d);
		if(ps.execute())
			status=1;
			System.out.println(status);
		}
		catch(Exception f) {System.out.println(f);}
		return status;
		
	}
	


	}

	



