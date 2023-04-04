package com.POMobjectrepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtilities;

public class accountsPage
{
public accountsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}


@FindBy(xpath = "//h4[.='Admin Account(s)']/../..//td[4]//a[@data-toggle='dropdown']")
private WebElement adminMoreBTN;

@FindBy(xpath ="//h4[.='Admin Account(s)']/../..//td[4]//i[@class='fas fa-fw fa-edit']")
private WebElement adminEditBTN;

@FindBy(xpath = "//a[@href='user.php?']/..//input[@name='firstname']")
private WebElement adminFN;

@FindBy(xpath = "//a[@href='user.php?']/..//input[@name='lastname']")
private WebElement adminLN;

@FindBy(xpath = "//a[@href='user.php?']/..//select[@name='gender']")
private WebElement selectAdmingender;

@FindBy(xpath = "//a[@href='user.php?']/..//input[@name='password']")
private WebElement adminPSW;

@FindBy(xpath = "//a[@href='user.php?']/..//button[@class='btn btn-warning btn-block']")
private WebElement updateBTN;

@FindBy(xpath = "//h4[.='Admin Account(s)']/../..//td[1]")
private WebElement adminFullname;


public String updateADmindetails(ExcellUtility elib,WebDriver driver,WebdriverUtilities wlib,JavaUtility jlib) throws Throwable
{
	adminMoreBTN.click();
	adminEditBTN.click();
	adminFN.clear();
	adminLN.clear();
	LinkedHashMap<String, String> adm = elib.readMultipleData("Sheet4");
	String fn=" ";
	String ln=" ";
	
	for(Entry<String, String> admlist:adm.entrySet())
	{
		if(admlist.getValue().equalsIgnoreCase("T"))
		{
			ln=jlib.Simrandom()+admlist.getValue();
			driver.findElement(By.xpath(admlist.getKey())).sendKeys(ln);
		}
		else if(admlist.getValue().equalsIgnoreCase("admin"))
		{
			fn=admlist.getValue();
			driver.findElement(By.xpath(admlist.getKey())).sendKeys(fn);
		}
		else
		{
		driver.findElement(By.xpath(admlist.getKey())).sendKeys(admlist.getValue());
		}
	}
	String adminName=fn+" "+ln;
	wlib.select(selectAdmingender, 1);
	Thread.sleep(1000);
	updateBTN.click();
	wlib.acceptalert(driver);
	return adminName;
	
}

public void verifyUpdateddet(String name)
{
	String actualname = adminFullname.getText();
	if(actualname.equalsIgnoreCase(name))
	{
		System.out.println( actualname+"  : admin details updated succesfully");
	}
	else
	{
		System.err.println("+++++++admin details not updated++++++++");
	}
}
public void getcountofusers(WebDriver driver)
{
List<WebElement> userlist = driver.findElements(By.xpath("//td[3]"));
int admincount=0;
int usercount=0;
for(WebElement type:userlist) {
	String typenm = type.getText();
	if(typenm.equalsIgnoreCase("Admin"))
	{
		admincount++;
	}
	if(typenm.equalsIgnoreCase("User"))
	{
		usercount++;
	}
}
System.out.println(admincount+" : admin present in list");
System.out.println(usercount+" : users are present in list");
}

}
