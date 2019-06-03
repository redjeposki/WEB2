package com.web2project.WEB2P;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:WEB2P;create=true";
    Connection conn;
    
    public DBConnection() {
    	try {
			this.conn = DriverManager.getConnection(JDBC_URL);
			if (this.conn != null)
				System.out.print("Connection with the Database successfully established");
		} catch (SQLException e) {
			System.out.println("Database connection error!");
			e.printStackTrace();
		}
    }
    
    
    public void createTable() {
    	try {
			conn.createStatement().execute("Create TABLE Users(ID INT, Name varchar(20), Surname varchar(20))");
			System.out.println("Table created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void insertIntoTable(int Id, String Name, String Surname) {
    	try {
			conn.createStatement().execute("INSERT INTO Users values ("+Id+",  '"+Name+"', '"+Surname+"')");
			System.out.println("Values inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void printRecords(String Table) {
    	ResultSet res = null;
		try {
			res = conn.createStatement().executeQuery("Select * FROM " + Table);
			while (res.next()) {
				try {
					System.out.println(res.getString("Name") + " " + res.getString("Surname") + "\n");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	
    }
}
