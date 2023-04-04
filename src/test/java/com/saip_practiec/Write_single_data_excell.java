package com.saip_practiec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_single_data_excell {

	public static void main(String[] args) throws Throwable
	{
		//step1 mention the path of the excell
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\simple.xlsx");	
		
		//step 2 open the excell
		Workbook book = WorkbookFactory.create(fis);
		
		//get the sheet
		Sheet sh = book.getSheet("Sheet1");

		//get the row
		Cell cel = sh.createRow(1).createCell(0);
		
		cel.setCellValue("rajeev");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\simple.xlsx");
		book.write(fout);
		book.close();

	}

}
