package com.qa.AliExpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import come.qa.AliExpress.utilities.Constants;
import come.qa.AliExpress.utilities.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	//creating page locators
	
	By emailId = By.xpath("//input[@type='text']");
	By passwordId = By.xpath("//input[@type='password']");
	By signButton =  By.xpath("//button[@type='submit']");

	//page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page action
	public String getloginPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE_STRING, 5);  
	}
	
	public AccountPage LoginCred(String un, String pwd) {
		System.out.println("login with username:" + un + "Password :" + pwd);
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(passwordId, pwd);
		elementUtil.doClick(signButton);

		return new AccountPage(driver);
	}
}
