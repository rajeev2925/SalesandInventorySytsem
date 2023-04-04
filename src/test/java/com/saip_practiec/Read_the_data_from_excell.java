package com.saip_practiec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_the_data_from_excell {

	public static void main(String[] args) throws Throwable
	{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\simple.xlsx");
	
	Workbook book = WorkbookFactory.create(fis);
	
	Cell cel = book.getSheet("Sheet1").getRow(1).getCell(0);
	
	String value = cel.toString();
	System.out.println(value);
	}
	

}
