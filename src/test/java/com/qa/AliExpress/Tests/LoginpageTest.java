package com.qa.AliExpress.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.AliExpress.driverbase.BaseStartTest;

import come.qa.AliExpress.utilities.Constants;

public class LoginpageTest extends BaseStartTest{

	@Test(priority = 1)
	public void verifyLoginpageTitleTest() {
	String title = loginpage.getloginPageTitle();
	System.out.println("login page title is :" + title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE_STRING);
	}
	
	@Test(priority = 2)
	public void loginTest() {
		loginpage.LoginCred(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
