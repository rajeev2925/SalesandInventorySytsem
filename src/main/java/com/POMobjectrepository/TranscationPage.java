package com.POMobjectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TranscationPage
{
@FindBy(xpath = "//input[@type='search']")
private WebElement search_TF;

@FindBy(xpath = "//tr//td[2]")
private WebElement customerNameList;

@FindBy(xpath = "//table[@class='table table-bordered']//tbody//td[1]")
private WebElement actual_name;


public TranscationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public void verify_Bill(String name,WebDriver driver, String pname,homePage hp)
{
	boolean flag=false;
	int len=1;
	for(int i=1;i<=len;i++)
	{
		
	
	search_TF.sendKeys(name);
	List<WebElement> clist = driver.findElements(By.xpath("//tr//td[2]"));
		len=clist.size();
		 driver.findElement(By.xpath("//tr["+i+"]//td[4]//a")).click();
String actual_res = actual_name.getText();
if(actual_res.equals(pname))
{
	System.out.println("bill success");
	flag=true;
	break;
}
else
{
hp.getTransactionM_TAB();
}	
	}
	
	if(!flag)
	{
		System.err.println("bill not generated");
	}
}

}