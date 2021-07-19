package com.qa.AliExpress.driverbase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.AliExpress.driver.WebDriverFactory;
import com.qa.AliExpress.pages.AccountPage;
import com.qa.AliExpress.pages.LoginPage;

public class BaseStartTest {

	WebDriver driver;
	WebDriverFactory df;
	public Properties prop;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	@BeforeTest
	public void setup() {
		df = new WebDriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
