package com.qa.AliExpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import come.qa.AliExpress.utilities.Constants;
import come.qa.AliExpress.utilities.ElementUtil;

public class AccountPage {

	private ElementUtil elementUtil;
	
	private By header = By.xpath("//span[@class='logo-base']");
	private By searchbox = By.cssSelector("div.search-key-box input");
	private By searchButton = By.xpath("//input[@class='search-button']");
	
	
	public AccountPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.ACCOUNT_PAGE_TITLE_STRING, 5);
	}
	
	public String getHeaderValue() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	public void dosearch(String ProductName) {
		elementUtil.doSendKeys(searchbox, ProductName);
		elementUtil.doClick(searchButton);
	}
	
	
}
