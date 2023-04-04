package com.POMobjectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtilities;

public class SuplierPage
{
@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
private WebElement Add_supplierBTN;

@FindBy(xpath = "//input[@name='companyname']")
private WebElement company_nameTf;

@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/../..//input[@name='phonenumber']")
private WebElement company_phonenumTF;

@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/../..//select[@name='province']")
private WebElement povienceDD;

@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/../..//select[@name='city']")
private WebElement cityDD;;

@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/../..//button[@type='submit']")
private WebElement saveBTN;

public SuplierPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}


public void getadd_suplierBTN()
{
	Add_supplierBTN.click();
}

public String Add_suplier_det(ExcellUtility elib,JavaUtility jlib,WebdriverUtilities wlib) throws Throwable
{
String cn = elib.readDatafromexcel("Sheet1", 0, 3);
String ph = elib.readDatafromexcel("Sheet1", 1, 3);
String Cname=cn+jlib.random();
String Cphone=ph+jlib.random();
company_nameTf.sendKeys(Cname);
wlib.selectbyvisibletext(povienceDD,"Aklan");
wlib.select(cityDD, 2);
company_phonenumTF.sendKeys(Cphone);
saveBTN.click();
return Cphone;
}

public String Verify_suplier(WebDriver driver,String phonenum,WebdriverUtilities Wlib)
{
	  boolean flag=false;
	    // System.out.println(phonenum);
	  String cname=null;
  	for(;;)
  	{
  		try {
  		 List<WebElement> compnum = driver.findElements(By.xpath("//tr/td[4]"));
  		 int count = compnum.size();
  		 for(int i=0;i<count;i++)
  		 {
  		  String phone = compnum.get(i).getText();
  		 
  		  	if(phone.equals(phonenum))
  		  	{
             cname = driver.findElement(By.xpath("//tr/td[.='"+phonenum+"']/../td[1]")).getText();
          
  		  			System.out.println(phonenum+" Suplier added succesfully");
  		  			flag=true;
  		  		 
  		  			break;
  		  		
  		  	}
  		
  		 }
  		}catch (Exception e) {
				
			}
  	
  		 	if(!flag)
  		 	{
  		 		WebElement next = driver.findElement(By.xpath("//a[.='Next']"));
  		 		Wlib.ScrollToElement(driver, next);
  		 		next.click();
  		 	}
  		 	else
  		 	{
  		 		break;
  		 	}
  	}
    return cname;
}
}
