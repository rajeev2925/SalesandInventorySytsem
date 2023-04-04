package com.saip_practiec;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class upadtedatainthedatabasetest {

	public static void main(String[] args) throws Throwable {
	//step 1 register the database
		int result=0;
		try {
	Driver driver = new Driver();
	 DriverManager.registerDriver(driver);
	
	//step 2 get coonection for database
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","root");
	
	//create statement
	Statement state = con.createStatement();
	String query = "update idata set name='rajeev' where id=r;";
	result = state.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		
	if(result==1) {
		System.out.println("data updated");
	}
	else
	{
		System.out.println("data not updated");
	}
		}
	}

}
