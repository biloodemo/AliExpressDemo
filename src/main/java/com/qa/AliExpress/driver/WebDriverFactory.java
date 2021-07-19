package com.qa.AliExpress.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class will help us to initilize the driver
 *
 */
public class WebDriverFactory {
public WebDriver driver;

public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();



	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser"); 
		
		System.out.println("browser name is : " + browserName);
		
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("please pass the correct browser name:" + browserName);
			break;
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties init_prop() {
		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/configuration/configuration.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenshot() {
		File src =((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
	
}
