package User_Module;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Generate_bill_for_new_customer {

	public static void main(String[] args)
	{

		 Random rnd = new Random();
			int cat= rnd.nextInt(99);
			
			String fname=+cat+"RARE";
			String  phone="907"+cat+"546"+cat;
			String lname="RABBIT";
			String name=fname+" "+lname;
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.findElement(By.name("user")).sendKeys("test");
	      driver.findElement(By.name("password")).sendKeys("test");
	      driver.findElement(By.name("btnlogin")).click();
			driver.switchTo().alert().accept();
			
			//driver.findElement(By.xpath("//li[@class='nav-item']["+i+"]")).click();
		
		driver.findElement(By.xpath("//a[.='Keyboard']")).click();
		WebElement p = driver.findElement(By.xpath("//div[@class='tab-content']//form[@action='pos.php?action=add&id=73581']//input[@value='oppo']"));
		String pname = p.getAttribute("value");
		driver.findElement(By.xpath("//div[@class='tab-content']//form[@action='pos.php?action=add&id=73581']//input[@value='Add']")).click();
		
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		
     driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']/..//input[@name='firstname']")).sendKeys(fname);
	     
	     driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']/..//input[@name='lastname']")).sendKeys(lname);
	     
	 driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']/..//input[@name='phonenumber']")).sendKeys(phone);
	   
	    
	 driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']/..//button[@type='submit']")).click();
	 
	 driver.switchTo().alert().accept();
	 
	 WebElement dd = driver.findElement(By.xpath("//select[@name='customer']"));
	 Select sel=new Select(dd);
		dd.click();
		 sel.selectByVisibleText(name);
		 
		 driver.findElement(By.xpath("//button[.='SUBMIT']")).click();
			
			driver.findElement(By.xpath("//input[@name='cash']")).sendKeys("10");
			
			driver.findElement(By.xpath("//input[@name='cash']/../../../..//button[@type='submit']")).click();
			
			driver.switchTo().alert().accept();
			
			  driver.findElement(By.xpath("//a[@id='userDropdown']")).click();
			     
			     driver.findElement(By.xpath("//a[@data-target='#logoutModal']")).click();
			     
			     driver.findElement(By.xpath("(//a[@href='logout.php'])[1]")).click();
			     
			     driver.findElement(By.name("user")).sendKeys("unguardable");
			      driver.findElement(By.name("password")).sendKeys("admin");
			      driver.findElement(By.name("btnlogin")).click();
			     driver.switchTo().alert().accept();
			     driver.findElement(By.xpath("//a[@href='transaction.php']")).click();
			     Boolean flag=false;
			    int len=2;
			    for(int i=1;i<=len;i++)
					{ 
			     driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
			    
			  List<WebElement> clist = driver.findElements(By.xpath("//tr//td[2]"));
			  		len=clist.size();
			       
				     
			    	
			    	 driver.findElement(By.xpath("//tr["+i+"]//td[4]//a")).click();
		
			    	 String billcus = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody//td[1]")).getText();
			    	 if(billcus.equals(pname))
			    	 {
			    		 System.out.println(name+" bill genertaed succusfully and it is stored in transaction");
			    		flag=true;
			    		 
			    	 }
			    	 else {
			    		 
			    		 driver.findElement(By.xpath("//a[@href='transaction.php']")).click();
			    	 }
					}
			    	if(!flag)
			    	{
			    		System.out.println("not present");
			    	}
			    	
			    	
			  	  driver.findElement(By.xpath("//a[@id='userDropdown']")).click();
				     
				     driver.findElement(By.xpath("//a[@data-target='#logoutModal']")).click();
				     
				     driver.findElement(By.xpath("(//a[@href='logout.php'])[1]")).click();
				     
				     driver.quit();

	}

}
