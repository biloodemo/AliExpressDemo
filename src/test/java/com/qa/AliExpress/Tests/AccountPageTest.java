package com.qa.AliExpress.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.AliExpress.driverbase.BaseStartTest;

import come.qa.AliExpress.utilities.Constants;

public class AccountPageTest extends BaseStartTest {

	@BeforeClass
	public void accountpagesetup() {
		accountpage = loginpage.LoginCred(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test
	public void accountPageTitleTest() {
		String title = accountpage.getAccountPageTitle();
		System.out.println("account page title :" + title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE_STRING);
	}
	@Test
	public void verifyAccountPageHeaderTest() {
		String accountheader = accountpage.getHeaderValue();
		Assert.assertEquals(accountheader, Constants.ACCOUNT_PAGE_HEADER_STRING);
	}
	@DataProvider
	public Object[][] ProductTestData() {
        return new Object[][] { { "Watches" }, { "Hats" } };

		}
	
	@Test(dataProvider = "ProductTestData")
	public void searchTest(String productname) {
		accountpage.dosearch(productname);
	}
}
