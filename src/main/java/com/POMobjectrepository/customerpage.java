package com.POMobjectrepository;

import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.JavaUtility;

public class customerpage
{
public customerpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@href='#' and @type='button']")
private WebElement Create_cust_Btn;

@FindBy(xpath="//form[@action='cust_transac.php?action=add']//input[@name='firstname']")
private WebElement firstname;

@FindBy(xpath="//form[@action='cust_transac.php?action=add']//input[@name='lastname']")
private WebElement lastname;

@FindBy(xpath="//form[@action='cust_transac.php?action=add']//input[@name='phonenumber']")
private WebElement phonenumber;

@FindBy(xpath="//form[@action='cust_transac.php?action=add']//button[@class='btn btn-success']")
private WebElement SaveBtn;

@FindBy(xpath = "//input[@type='search']")
private WebElement SearchTF;

@FindBy(xpath = "//td[3]")
 private WebElement phonenumcolumn;

public WebElement getCreate_cust_Btn() {
	return Create_cust_Btn;
}

public WebElement getFirstname() {
	return firstname;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getPhonenumber() {
	return phonenumber;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

public WebElement getSearchTF() {
	return SearchTF;
}
public WebElement getphonenumcolumn()
{
	return phonenumcolumn;
}

public String addcustomer(WebDriver driver,ExcellUtility elib,JavaUtility jlib) throws Throwable
{
	LinkedHashMap<String, String> map = elib.readMultipleData("Sheet1");
	String phone=null;
	for( Entry<String, String> custdet:map.entrySet())
	{
		phone = custdet.getValue()+jlib.random();
		if(custdet.getKey().equals("phonenumber"))
		{
			driver.findElement(By.name(custdet.getKey())).sendKeys(phone);
		}
		else
		{
		driver.findElement(By.name(custdet.getKey())).sendKeys(custdet.getValue());
	}
		}
	SaveBtn.click();
	return phone;
}
	public void verifyaddedcust(String phone)
	{
		SearchTF.sendKeys(phone);
		String actual = phonenumcolumn.getText();
			  
			    
			    if(actual.equals(phone))
			    {
			    System.out.println("customer data present in customer list");	
			    }
			    else
			    {
			    	System.err.println("customer not Added");
			    }
	}

}
