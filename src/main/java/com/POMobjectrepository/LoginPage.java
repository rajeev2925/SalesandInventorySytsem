package com.POMobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtilities;

public class LoginPage
{

	@FindBy(name="user")
	private WebElement usernameTF;
	
	@FindBy(name="password")
	private WebElement passwordTF;
	
	@FindBy(name="btnlogin")
	private WebElement loginBTN;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pass,FileUtility Flib,WebdriverUtilities wlib,WebDriver driver) throws Throwable
	{
		usernameTF.sendKeys(Flib.readDatafronPropertyFile(un));
		passwordTF.sendKeys(Flib.readDatafronPropertyFile(pass));
		loginBTN.click();	
		wlib.acceptalert(driver);
	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBTN() {
		return loginBTN;
	}

	
	
	
}
