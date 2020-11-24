package collection;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class DeleteDB {



			public static int shop(int sid) {
				
				// TODO Auto-generated method stub
				int status =0;
				try {
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from shop where sid=?");
				ps.setInt(1,sid);
				
				//ps.setString(4,d);
				if(ps.execute())
					status=1;
					System.out.println(status);
				}
				catch(Exception f) {System.out.println(f);}
				return status;
				
		
	}
			
			
public static int deletepro(int pid) {
				
				// TODO Auto-generated method stub
				int status =0;
				try {
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from product where pid=?");
				ps.setInt(1,pid);
				
				//ps.setString(4,d);
				if(ps.execute())
					status=1;
					System.out.println(status);
				}
				catch(Exception f) {System.out.println(f);}
				return status;
				
		
	 }
	}

	
	
