package Threads;

import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.rowset.*;

import javax.sql.rowset.CachedRowSet;

import collection.DB;

public class MultiThreading{

	ServerSocket serverSocket = null;
	Socket socket = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Boolean alreadyExecuted = false;
	
	public MultiThreading(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Runnable task1 = new Runnable() {
			
			public void run() {
				try{
					while(true){
				    serverSocket = new ServerSocket(4045);
					socket=serverSocket.accept();
					System.out.println("Connected");
					ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
					outputStream.flush();
					ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
					
						System.out.println("F");
						String query = (String) inputStream.readObject();
						System.out.println(query);
					    con = (Connection) DB.getConnection();
					    ps = (PreparedStatement) con.prepareStatement(query);
						rs = ps.executeQuery();
						RowSetFactory fa= RowSetProvider.newFactory();
						CachedRowSet crs = fa.createCachedRowSet();
						crs.populate(rs);
						
						outputStream.writeObject(crs);
						socket.close();
						serverSocket.close();
					}
					
					
				}catch(Exception e){System.out.println(e);}
			}
		};
		
		executorService.submit(task1);
	}
}