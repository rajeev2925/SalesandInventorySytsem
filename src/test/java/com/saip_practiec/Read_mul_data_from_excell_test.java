package com.saip_practiec;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Read_mul_data_from_excell_test 
{
	 
public static void main(String [] args) throws Throwable
{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\simple.xlsx");
	
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh = book.getSheet("Sheet1");
	int LRC = sh.getLastRowNum();	
	for(int i=1;i<=LRC;i++)
	{
		Row rw = sh.getRow(i);
		short LCC = rw.getLastCellNum();
		for(int j=0;j<LCC;j++)
		{
		String val = rw.getCell(j).getStringCellValue();
		System.out.print(val+"   " );
		}
		System.out.println("");
	}
}
}
