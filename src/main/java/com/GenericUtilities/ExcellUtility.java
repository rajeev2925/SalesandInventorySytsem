package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility 
{
	
	public String readDatafromexcel(String shaeetname,int rowno,int cellno) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.XLPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(shaeetname);
		String value = sheet.getRow(rowno).getCell(cellno).toString();
		return value;
	}
	
	public int getlastRowNo(String shaeetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.XLPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(shaeetname);
		int lastrownum = sheet.getLastRowNum();
		return lastrownum;
	}
  
	public void writeDataToExcell(String shaeetname, int rowno, int cellno, Date data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.XLPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(shaeetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream(IPathConstants.XLPATH);
		book.write(fout);	
	}
	
	public LinkedHashMap<String, String> readMultipleData(String shaeetname) throws Throwable
	{
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		FileInputStream fis = new FileInputStream(IPathConstants.XLPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(shaeetname);
		int LRN = sheet.getLastRowNum();
	     for(int i=0;i<=LRN;i++)
		{
		String key = sheet.getRow(i).getCell(0).toString();
		String value = sheet.getRow(i).getCell(1).toString();
		map.put(key, value);
		
		}
		
		return map;
	}
	
	public Object[][] readSetOfData(String sheetname) throws Throwable
	{
	FileInputStream fis = new FileInputStream(IPathConstants.XLPATH);
	 Workbook book = WorkbookFactory.create(fis); 
	 Sheet sheet = book.getSheet(sheetname);
	int lastrow = sheet.getLastRowNum()+1;
	short lcn = sheet.getRow(0).getLastCellNum();
	Object[][] arr=new Object[lastrow][lcn];
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lcn;j++)
		{
		 arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return arr;
	
	}
}
