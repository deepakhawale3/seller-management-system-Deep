package collection;
import java.sql.*;
public class OrderDB {
	
	
	public static int save(int sid,String pname ,int quantity ,int total ){
		int status=0,pid=0;
		String sname=null;
		try{
			Connection con=DB.getConnection();
			
			//updating quantity and issue
			
			
			
			PreparedStatement ps1=con.prepareStatement("select sname from shop where sid = '" + sid + "'");	
			ResultSet rs=ps1.executeQuery();
			rs.next();
			if(rs != null) 
			{
				
				
				sname=(rs.getString("sname"));
					
									
			}
		
			
		
			
		
			PreparedStatement ps2=con.prepareStatement("select pid from product where pname = ?");
			ps2.setString(1, pname);
			ResultSet rs2=ps2.executeQuery();
			rs2.next();
			if(rs2 != null) {
				
				pid=(rs2.getInt("pid"));
			}
		
			
		
		
		
			PreparedStatement ps3=con.prepareStatement("insert into `order`(sid,sname,pid,pname,quantity,total) values(?,?,?,?,?,?)");
			ps3.setInt(1,sid);
			ps3.setString(2, sname);
			ps3.setInt(3, pid);
			ps3.setString(4,pname);
			ps3.setInt(5, quantity);
			ps3.setInt(6, total);
			
				System.out.println(status);
				ps3.execute();
			
			
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	

}
