package com.cloudops.genericlib;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cloudops.pagelib.LoginPage;
import com.cloudops.pagelib.SignUpPage;
import com.cloudops.pagelib.SignUpPage.Currency;

public class SolventSelenium {
	
	public static RemoteWebDriver driver;
	
	public static void LaunchBrowser() {
		
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("version", "");
//		capabilities.setCapability("platform", "LINUX");
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.13.0-win64\\geckodriver.exe");
//		try {
//			driver = new RemoteWebDriver(new URL("http://ec2-35-154-136-240.ap-south-1.compute.amazonaws.com:4446/wd/hub"), capabilities);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ProfilesIni profile = new ProfilesIni();
		 
		FirefoxProfile myprofile = profile.getProfile("customprofile");
		
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://staging.cloudops.ai/");
		waitForPageToLoad();
		
	}
	
	public static void Login(String username, String password){
		LaunchBrowser();
		SignUpPage.getLoginLink().click();
		waitForElementToAppear(LoginPage.getLoginFormHeader());
		LoginPage.getUsername().sendKeys(username);
		LoginPage.getPassword().sendKeys(password);
		LoginPage.getLoginButton().submit();
		waitForElementToAppear(driver.findElement(By.xpath("//div[@id='log-out']//button//div[@class='label']")));
		//waitForPageToLoad();
		
	}
	
	public static void LoginWithInvalidCred(String username, String password){
		LaunchBrowser();
		SignUpPage.getLoginLink().click();
		waitForElementToAppear(LoginPage.getLoginFormHeader());
		LoginPage.getUsername().sendKeys(username);
		LoginPage.getPassword().sendKeys(password);
		LoginPage.getLoginButton().submit();
		//waitForElementToAppear(driver.findElement(By.xpath("//div[@id='log-out']//button//div[@class='label']")));
		//waitForPageToLoad();
		
	}
	
	public static void signUp(String companyName, String email, String phoneNumber, String password, Currency currency){
		
		LaunchBrowser();
		SignUpPage.getCompanyField().sendKeys(companyName);
		SignUpPage.getEmailField().sendKeys(email);
		SignUpPage.getPhoneNumberField().sendKeys(phoneNumber);
		SignUpPage.getPasswordField().sendKeys(password);
		SignUpPage.getPasswordConfirmationField().sendKeys(password);
		SignUpPage.selectCurrency(currency);
		SignUpPage.getRegisterButton().submit();
		waitForPageToLoad();
		
	}

	public static void waitForPageToLoad() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 30);

	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
		
	}
	
	public static void waitForElementToAppear(WebElement element){
		
		WebDriverWait wait = new WebDriverWait(driver, 120);

	    wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void logoutUser(){
		
		driver.findElement(By.xpath("//div[@id='log-out']//button//div[@class='label']")).click();
		driver.findElement(By.xpath("//div[@id='log-out']//ul/li//button[text()='Logout']")).click();
		waitForElementToAppear(driver.findElement(By.xpath("//div[@id='logoutModal']//a[@href='/logout']")));
		driver.findElement(By.xpath("//div[@id='logoutModal']//a[@href='/logout']")).click();
		waitForElementToAppear(SignUpPage.getLoginLink());
		
	}

}
