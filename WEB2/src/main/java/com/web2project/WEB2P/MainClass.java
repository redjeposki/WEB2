package com.web2project.WEB2P;

public class MainClass {

	public static void main(String[] args) {
		System.out.print("it's Working");
		DBConnection DBC = new DBConnection();
		//DBC.createTable();
		//DBC.insertIntoTable(1, "Elvis", "Redjeposki");
		//DBC.insertIntoTable(2, "John", "John");
		DBC.printRecords("Users");
	}

}
