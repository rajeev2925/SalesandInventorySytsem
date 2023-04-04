package com.saip_practiec;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.bouncycastle.crypto.ec.ECPair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWebShop_Test {

	public static void main(String[] args) throws Throwable 
	{
		
		FileUtility Flib = new FileUtility();
	WebdriverUtilities Wlib = new WebdriverUtilities();
	ExcellUtility Elib = new ExcellUtility();
	JavaUtility Jlib = new JavaUtility();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disabled-notifications");
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		Wlib.maximizewindow(driver);
		String URL = Flib.readDatafronPropertyFile("DwsUrl");
		String UN = Flib.readDatafronPropertyFile("Dwsun");
		String psw = Flib.readDatafronPropertyFile("Dwspsw");
		driver.get(URL);
		Wlib.waitforpageload(driver);
		driver.findElement(By.xpath("//a[.='Log in']")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(UN);
		driver.findElement(By.id("Password")).sendKeys(psw);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/books']")).click();
		
		WebElement book1 = driver.findElement(By.xpath("//a[.='Computing and Internet']"));
		Wlib.ScrollToElement(driver, book1);
		//Wlib.elementtobevisible(driver, book1);
		book1.click();
		
		driver.findElement(By.xpath("//h1[@itemprop='name']/../..//input[@value='Add to cart']")).click();
		
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/books']")).click();
		
		String exp_comp_book = driver.findElement(By.xpath("//a[.='Computing and Internet']")).getText();
		
		WebElement book = driver.findElement(By.xpath("//a[.='Computing and Internet']/../..//input[@type='button']"));
//		Wlib.ScrollToElement(driver, book);
		book.click();
		//String exp_fiction = driver.findElement(By.xpath("//a[.='Fiction']")).getText();
		
//		WebElement book2 = driver.findElement(By.xpath("//a[.='Fiction']/../..//input[@type='button']"));
////		Wlib.elementtobevisible(driver, book2);
//		book1.click();
		
		WebElement Shcart = driver.findElement(By.xpath("//span[.='Shopping cart']"));
//		Wlib.ScrollToElement(driver, Shcart);
//		Wlib.elementtobevisible(driver, Shcart);
		Shcart.click();
		//System.out.println(exp_comp_book);
		List<WebElement> Actualproducts = driver.findElements(By.xpath("//table[@class='cart']//tbody//tr//td[3]/a"));
		List<WebElement> cartproducts = driver.findElements(By.xpath("//table[@class='cart']//tbody//tr//td[3]/a"));
		Boolean flag=false;
		for(WebElement pdetails:Actualproducts)
		{
			String actual = pdetails.getText();
			if(actual.equals(exp_comp_book))
			{
				System.out.println(exp_comp_book+" :present in shopping cart");
				flag=true;
				break;
			}
			
		}
		if(!flag)
		{
			System.out.println("not present");
			
		}
		if(flag=true)
		{
		
		List<WebElement> Qty = driver.findElements(By.xpath("//table[@class='cart']//tbody//tr//td[5]//input"));
		for(WebElement quantity:Qty)
		{
			
			String value = quantity.getAttribute("value");
			int v = Integer.parseInt(value);
			if(v>1)
			{
				driver.findElement(By.xpath("//table[@class='cart']//tbody//tr//td[5]//input[@value='"+value+"']/../..//td[1]")).click();	
				//driver.findElement(By.xpath("//input[@name='updatecart']")).click();
			}
			else
			{
				
			}
		}
	
		
		driver.findElement(By.xpath("//input[@name='termsofservice']")).click();
		
		driver.findElement(By.xpath("//button[@name='checkout']")).click();
		
		WebElement Address_dd = driver.findElement(By.xpath("//select[@name='billing_address_id']"));
		Address_dd.click();
		Wlib.selectbyvisibletext(Address_dd, "New Address");
		
		LinkedHashMap<String, String> map = Elib.readMultipleData("Sheet2");
		for(Entry<String, String> mapdata:map.entrySet())
		{
			String key = mapdata.getKey();
			String value = mapdata.getValue();
			if(key.equals("BillingNewAddress.PhoneNumber"))
			{
			driver.findElement(By.name(key)).sendKeys(value+Jlib.random());
			}
			else
			{
			driver.findElement(By.name(key)).sendKeys(value);
			}
		}
		WebElement count_dd = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Wlib.selectbyvisibletext(count_dd, "India");
	//	option.addArguments("--disable-notifications");
		
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		
		String orderNo = driver.findElement(By.xpath("//a[.='Click here for order details.']/../../li[1]")).getText();
		
		driver.findElement(By.xpath("//a[.='Click here for order details.']")).click();


System.out.println(orderNo);
		
		List<WebElement> Actualproductinbill = driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr/td[1]/em/a"));
				for(WebElement ACTbill:Actualproductinbill)
	{
			String ACT = ACTbill.getText();
//		for(WebElement EXPbill:cartproducts)
//			{
//			String EXP = EXPbill.getText();
				if(ACT.equalsIgnoreCase("Computing and Internet"))
				{
					System.out.println(ACT+ "present in bill");
				}
				else
				{
					System.out.println(ACT+ "not present in bill");
				}
			}
		}
		driver.findElement(By.xpath("//a[.='Log out']")).click();
		
		
	}

}

