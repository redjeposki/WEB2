package com.web2project.WEB2P;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTools {
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:WEB2P;create=true";
    Connection conn;
    
    public DBTools() {
    	try {
			this.conn = DriverManager.getConnection(JDBC_URL);
			if (this.conn != null)
				System.out.print("Connection with the Database successfully established");
		} catch (SQLException e) {
			System.out.println("Database connection error!");
			e.printStackTrace();
		}
    }
    
    
    public void createTable(String name) {
    	try {
			conn.createStatement().execute("Create TABLE " + name + " (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), Name varchar(20), Surname varchar(20))");
			System.out.println("Table created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void createCustomTable() {
    	try {
			conn.createStatement().execute("Create TABLE userin (uID INTEGER, Name varchar(20), Surname varchar(20), Birthday varchar(10), Email varchar(50), isAdmin BOOLEAN)");
			System.out.println("Table created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void insertIntoTable(String tableName, String Name, String Surname) {
    	try {
			conn.createStatement().execute("INSERT INTO " + tableName + " (Name, Surname) values ('"+Name+"', '"+Surname+"')"); //"+Id+",  
			System.out.println("Values inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void createSequence() {
    	try {
    		/*
			conn.createStatement().execute("CREATE SEQUENCE seq_abcd\r\n" + 
					"    START WITH 1\r\n" + 
					"    INCREMENT BY 1\r\n" + 
					"    NO MINVALUE\r\n" + 
					"    NO MAXVALUE");
			*/
    		conn.createStatement().execute("CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1 NO CYCLE");
			System.out.println("Sequence Created");
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
					System.out.println("\n" + res.getString("uID") + ": " + res.getString("Name") + " " + res.getString("Surname") + " "  + res.getString("Email"));
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
    
    public void dropTable(String table) {
    	try {
			conn.createStatement().execute("DROP TABLE " + table);
			System.out.println("\n" + "the Table: " + table + " removed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
