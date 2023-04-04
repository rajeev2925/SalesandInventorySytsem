package com.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebdriverUtilities
{
	private static final String TakesScreenshot = null;

	//this method is used to maximize the window
public void maximizewindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

	//this method is used to wait for page load until the specified time 
public void waitforpageload(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
	
	//this method will wait until the element visible for specified time
public void elementtobevisible(WebDriver driver, WebElement element)
{
 WebDriverWait wait=new WebDriverWait(driver,5);
 wait.until(ExpectedConditions.visibilityOf(element));
}

	//this method is used to fetch the element in dropdown based on visibletext
public void selectbyvisibletext(WebElement element, String text)
{
	Select select = new Select(element);
	select.selectByVisibleText(text);
}

//this method is used to fetch the element in dropdown based on value
public void select(WebElement element, String value)
{
	Select select = new Select(element);
	select.selectByValue(value);
}

////this method is used to fetch the element in dropdown based on index
public void select(WebElement element, int index)
{
	Select select = new Select(element);
	select.selectByIndex(index);
}

//this method is used to move the cursor to element
public void mouseover(WebDriver driver, WebElement element)
{
Actions act=new Actions(driver);
act.moveToElement(element).perform();
}

//this method used to perfom drag and drop
public void draganddrop(WebDriver driver, WebElement elementf, WebElement elementt)
{
Actions act=new Actions(driver);
act.dragAndDrop(elementf, elementt).perform();
}

//this method is used to perform double click action
public void doubleclick(WebDriver driver, WebElement element)
{
Actions act=new Actions(driver);
act.doubleClick(element).perform();
}

//this method is used to perform rightclick action
public void Rightclick(WebDriver driver, WebElement element)
{
Actions act=new Actions(driver);
act.contextClick(element).perform();
}

//
public void enterkeypress(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER);
}
public void enterpress() throws Throwable
{
	Robot rbt = new Robot();
	rbt.keyPress(KeyEvent.VK_ENTER);
}
public void enterrelease() throws Throwable
{
	Robot rbt = new Robot();
	rbt.keyRelease(KeyEvent.VK_ENTER);
}
public void switchtoframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
public void switchtoframe(WebDriver driver,String IdorName)
{
	driver.switchTo().frame(IdorName);
}
public void switchtoframe(WebDriver driver,WebElement address)
{
	driver.switchTo().frame(address);
}

public void acceptalert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void cancelalert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public void SwitchToWindow(WebDriver driver, String title)
{
	Set<String> window = driver.getWindowHandles();
	for(String windowlist:window)
	{
		String currentwindowtitle = driver.switchTo().window(windowlist).getTitle();
		if(currentwindowtitle.contains(title))
		{
			break;
		}
	}
}
public static String getScreenShot(WebDriver driver, String screenshotname) throws Throwable
{



	
	Date date = new Date();
	String cdt = date.toString();
	String rdate = cdt.replace(":","-");
TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String path = "./photos/failedtests"+rdate+".jpeg";
	File drc = new File(path);
	try {
		FileHandler.copy(src, drc);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;
}
public void scrollBaraction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)","");
}

/*this method will scroll untill the specified element found
 * param driver
 * param element adress
 */
public void ScrollToElement(WebDriver driver, WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	//js.executeScript("argument[0].scrollIntoView()", element);
}


}
