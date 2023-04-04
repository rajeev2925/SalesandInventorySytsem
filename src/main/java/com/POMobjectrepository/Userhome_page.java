package com.POMobjectrepository;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtilities;


public class Userhome_page 
{   
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement addnewcustomerBTN;

	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']/..//input[@name='firstname']")
	private WebElement fname;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']/..//input[@name='lastname']")
	private WebElement lname;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']/..//input[@name='phonenumber']" )
	private WebElement phonenumber;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']/..//button[@type='submit']")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//select[@name='customer']")
	private WebElement selectcustomerDD;
	
	@FindBy(xpath = "//button[.='SUBMIT']")
	private WebElement SubmitPOs;
	
	@FindBy(xpath = "//input[@name='cash']")
	private WebElement cashtF;
	
	@FindBy(xpath ="//button[.='SUBMIT']/..//input[@name='total']")
	private WebElement amount;
	
	@FindBy(xpath = "//input[@name='cash']")
	private WebElement  Entertotalamount;
	
	@FindBy(xpath = "//button[.='PROCEED TO PAYMENT']")
	private WebElement Payment;
	
	@FindBy(xpath = "//a[@id='userDropdown']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutBTN;
	
	@FindBy(xpath = "(//a[@href='logout.php'])[1]")
	private WebElement confirm_logout;
	
	
	
	
	
	
	public Userhome_page(WebDriver driver)
	   {
		PageFactory.initElements(driver, this);
	   }	
   
	
	
	
	
	
   public void sel_product_cat(WebDriver driver, String pcat)
   {
	  driver.findElement(By.xpath("//a[.='"+pcat+"']")).click();	  
   }
   
   public void Add_product(WebDriver driver, String pname)
   {
	   driver.findElement(By.xpath("//div[@class='col-sm-4 col-md-2']//div[@class='products']//h6[.='"+pname+"']/..//input[@value='Add']")).click();
	   
   }
 
   public String create_new_cust(ExcellUtility elib,JavaUtility jlib,WebdriverUtilities Wlib,WebDriver driver) throws Throwable
      {
	   addnewcustomerBTN.click();
	   LinkedHashMap<String, String> list = elib.readMultipleData("Sheet1");
	   String name = list.get("firstname")+jlib.random();
	   String lastname = list.get("lastname");
	   String phone = list.get("phonenumber")+jlib.random();
	   String Sname=name+" "+lastname;
	   fname.sendKeys(name);
	   lname.sendKeys(lastname);
	   phonenumber.sendKeys(phone);
	   saveBTN.click();
	   Wlib.acceptalert(driver);
	   return Sname;   
   }
   
   public void selectAddedCustomer(WebdriverUtilities wlib, String cname)
   {
	   selectcustomerDD.click();
	   wlib.selectbyvisibletext(selectcustomerDD, cname);
   }
   
   public void getSubmitPOs()
   {
	   SubmitPOs.click();
   }
   //payment option in user page
   public void PaymentOpt()
   {
	     String cash = amount.getAttribute("value");
	    Entertotalamount.sendKeys(cash);
	   Payment.click();
	      
   }
   
   
   public void logoutasEmployee() throws InterruptedException
   {
	   profileIcon.click();
	   logoutBTN.click();
	   Thread.sleep(2000);
	   confirm_logout.click();
   }
   //verifu the product which is added in the product page
   public void verify_product(WebDriver driver, String pname)
   {
	  String actual = driver.findElement(By.xpath("//div[@class='col-sm-4 col-md-2']//div[@class='products']//h6[.='"+pname+"']")).getText();
	  if(pname.equals(actual))
	  {
		  System.out.println("Added product is visible to cashier");
	  }
	  else
	  {
		  System.err.println("Added product is not visible to customer");
	  }
   }
}
