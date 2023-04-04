package com.GenericUtilities;


import java.io.FileInputStream;
import java.util.Properties;


public class FileUtility {
   public String readDatafronPropertyFile(String key) throws Throwable
   {
	   FileInputStream fis = new FileInputStream(IPathConstants.FILEPATH);
	   Properties pObj = new Properties();
	   pObj.load(fis);
	   String value = pObj.getProperty(key);
	   return value;
   }

}
