package com.saip_practiec;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_mul_data_to_excell {

	public static void main(String[] args) throws Throwable 
	{
		String [] name= {"abc","xyz","hgj"};
	 	String [] city= {"ghh","vjjkhk","ghj"};
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\simple.xlsx");
	 
	Workbook book = WorkbookFactory.create(fis);
	
	Sheet sh = book.getSheet("Sheet1");
	
	int rcout=7;
 	for(int i=0;i<name.length;i++)
 	{
 		System.out.println(name[i]+" "+city[i]);
 			sh.createRow(rcout).createCell(0).setCellValue(name[i]);
 			sh.getRow(rcout).createCell(1).setCellValue(city[i]);
 			FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\simple.xlsx");
 	 		book.write(fout);
 	 		rcout++;
 	}
 	} 	
}
