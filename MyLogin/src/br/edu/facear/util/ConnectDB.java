package br.edu.facear.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;

public class ConnectDB {

	private Connection con;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public ConnectDB() {
	driver =	"com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/MyLogin";
		
	//	driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// url = "jdbc:sqlserver://localhost:1434;databaseName=MyLogin";
		username = "sa";
		password = "admin27";
	}
	
		
		public Connection getConnection()  throws IOException, ClassNotFoundException , SQLException{
			
			Class.forName(driver);
			this.con = DriverManager.getConnection(url,username,password);
			return this.con;
			
			
			
		}
	}
	

