package com.saip_practiec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class selectdatafromdatbase {

	public static void main(String[] args) throws Throwable
	{
	
		//step1--> register the data base
		 Driver driver = new Driver(); 
		 DriverManager.registerDriver(driver);

		 //step 2-->get connection for the database
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","root");
		 
		 //step 3--> create statement 
		Statement state = con.createStatement();
		String query = "select Name,ph_num from idata where id=1;";
		
	
		
		
		//step5-->execute the query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"   "+result.getString(2));
		}
con.close();
	}

}
