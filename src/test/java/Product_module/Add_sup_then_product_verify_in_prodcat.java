package Product_module;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_sup_then_product_verify_in_prodcat {

	public static void main(String[] args) throws Throwable {
		
		FileUtility Flib = new FileUtility();
		WebdriverUtilities Wlib = new WebdriverUtilities();
		ExcellUtility Elib = new ExcellUtility();
		JavaUtility Jlib = new JavaUtility();
			  
			  
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
	    Wlib.maximizewindow(driver);
	    String URL = Flib.readDatafronPropertyFile("url");
	    String UN = Flib.readDatafronPropertyFile("adminusername");
	    String PSW = Flib.readDatafronPropertyFile("adminpassword");
	    driver.get(URL);
	    driver.findElement(By.name("user")).sendKeys(UN);
	      driver.findElement(By.name("password")).sendKeys(PSW);
	      driver.findElement(By.name("btnlogin")).click();
	    
	      Wlib.waitforpageload(driver);
	   
	      Wlib.acceptalert(driver);
	     
	     driver.findElement(By.xpath("//a[@href='supplier.php']")).click();
	     
	     driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
	     
	     String compname = Elib.readDatafromexcel("Sheet1", 0, 3);
	     String cname = compname+Jlib.random();
	      driver.findElement(By.xpath("//input[@name='companyname']")).sendKeys(cname);
	      
	      WebElement pdd = driver.findElement(By.xpath("//form[@action='sup_transac.php?action=add']/../..//select[@name='province']"));
	      pdd.click();
	      Wlib.selectbyvisibletext(pdd,"La Union");
	     
	     WebElement cdd = driver.findElement(By.xpath("//form[@action='sup_transac.php?action=add']/../..//select[@name='city']"));
	     cdd.click();
	     Wlib.selectbyvisibletext(cdd,"Luna");
	     
	     String pn = Elib.readDatafromexcel("Sheet1", 1, 3);
	     String phonenum = pn+Jlib.random();
	     driver.findElement(By.xpath
	    		 ("//form[@action='sup_transac.php?action=add']/../..//input[@name='phonenumber']")).sendKeys(phonenum);
	     System.out.println(phonenum);
	     driver.findElement(By.xpath("//form[@action='sup_transac.php?action=add']/../..//button[@type='submit']")).click();

       // driver.findElement(By.xpath("//input[@type='search']")).sendKeys(phonenum);
	     
     boolean flag=false;
	     
    
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
    }
}	

