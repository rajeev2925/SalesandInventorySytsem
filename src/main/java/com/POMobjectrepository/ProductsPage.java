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

public class ProductsPage

{
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement Add_productBTN;
	
	@FindBy(xpath = "//input[@name='datestock']")
	private WebElement dateStockIn;
	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement SelCategory;
	
	@FindBy(xpath = "//select[@name='supplier']")
	private WebElement SelSupplier;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']//button[@class='btn btn-success']")
	private WebElement savePBTN;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchProdCode;
	
	@FindBy(xpath ="//tbody//tr//td[2]")
	private WebElement poductidlist;
	
	

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	public void getAdd_productBTN() {
		Add_productBTN.click();
	}
	
public String Add_Product(ExcellUtility elib,JavaUtility jlib,WebDriver driver,WebdriverUtilities wlib, String Sname) throws Throwable
{
	
	LinkedHashMap<String, String> plist = elib.readMultipleData("prodPage");
	String PName=null;
	String PCode=null;
	for(Entry<String, String> list:plist.entrySet())
	{
		
		
		if(list.getKey().equals("//input[@name='name']"))
		{
		PName = list.getValue()+jlib.random();
		driver.findElement(By.xpath(list.getKey())).sendKeys(PName);
	}
		else if(list.getValue().equals("0"))
		{
			PCode=list.getValue()+jlib.random();
			driver.findElement(By.xpath(list.getKey())).sendKeys(PCode);
		}
		else
		{
			driver.findElement(By.xpath(list.getKey())).sendKeys(list.getValue());
	}
	}
	SelCategory.click();
	wlib.selectbyvisibletext(SelCategory, "Others");
	SelSupplier.click();
	wlib.selectbyvisibletext(SelSupplier,Sname);
	dateStockIn.click();
	String cdate = jlib.SystemDate();
	dateStockIn.sendKeys(cdate);
	savePBTN.click();
	return PName;
}

public void Verify_product(String pname)
{
	searchProdCode.sendKeys(pname);
	 String actualid=poductidlist.getText();
	if(actualid.equalsIgnoreCase(pname))
	{
		System.out.println("product added");
	}
	else
	{
		System.err.println("product not added");
	}
}
}
