package com.POMobjectrepository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class homePage 
{
public homePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

@FindBy(xpath="//a[@href='customer.php']")
private WebElement CustomerM_TAB;

@FindBy(xpath="//a[@href='transaction.php']")
private WebElement TransactionM_TAB;

@FindBy(xpath = "//a[@href='supplier.php']")
private WebElement SupplierM_TAB;

@FindBy(xpath = "//a[@href='product.php']")
private WebElement productM_TAB;

@FindBy(xpath = "//a[@href='user.php']")
private WebElement accountsM_TAB;




@FindBy(xpath = "//a[@id='userDropdown']")
private WebElement profileIcon;

@FindBy(xpath = "//a[@data-target='#logoutModal']")
private WebElement logoutBTN;

@FindBy(xpath = "(//a[@href='logout.php'])[1]")
private WebElement confirm_logout;

public WebElement getcustomerM_tab() 
{
	return CustomerM_TAB;
}

public void getTransactionM_TAB()
{
	TransactionM_TAB.click();
}
public void getSupplierM_TAB() {
	SupplierM_TAB.click();
}
public void getaccountsM_TAB() {
	accountsM_TAB.click();
}


public void getProductM_TAB()
{
	productM_TAB.click();
}

public void Admin_logout() throws InterruptedException
{
	profileIcon.click();
	logoutBTN.click();
	Thread.sleep(2000);
	confirm_logout.click();
}
}
