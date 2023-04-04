package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.POMobjectrepository.homePage;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.GenericUtilities.listnerimplimentation.class)
public class BaseClass 
{
	
public DatabaseUtility dlib=new DatabaseUtility();
public FileUtility flib=new FileUtility();
public ExcellUtility elib=new ExcellUtility();
public JavaUtility jlib=new JavaUtility();
public WebdriverUtilities wlib=new WebdriverUtilities();
public WebDriver driver;
public static WebDriver edriver;
	
@BeforeSuite(alwaysRun = true)
public void configBS() throws Throwable
{
	//dlib.connectToDb();
	//System.out.println("----DB connected----");
}
//@Parameters("BROWSER")
@BeforeClass(alwaysRun = true)
public void configBC()
{
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
		
	edriver=driver;
	wlib.maximizewindow(driver);
	
}
@BeforeMethod
public void configBM() throws Throwable
{
	driver.get(flib.readDatafronPropertyFile("url"));
	wlib.waitforpageload(driver);
}

@AfterMethod(alwaysRun = true)
public void ConfigAM() throws InterruptedException
{
	new homePage(driver).Admin_logout();
}
@AfterClass(alwaysRun = true)
public void configAC()
{
	driver.quit();
}
@AfterSuite(alwaysRun = true)
public void configAS() throws Throwable
{
	//dlib.closeDB();
}
}
