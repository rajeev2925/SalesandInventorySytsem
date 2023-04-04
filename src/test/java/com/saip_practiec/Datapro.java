package com.saip_practiec;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IPathConstants;

public class Datapro
{
	@DataProvider
	public Object[][] data() throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.XLPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet3");
		int LR = sh.getLastRowNum()+1;
		short lc = sh.getRow(0).getLastCellNum();
		Object [][] arr=new Object[LR][lc];
		
		for(int i=0;i<LR;i++)
		{
			for(int j=0;j<lc;j++)
			{
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
		
	}
	
}
