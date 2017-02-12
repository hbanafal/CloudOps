package com.cloudops.pagelib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cloudops.genericlib.SolventSelenium;

public class SignUpPage extends SolventSelenium {
	
//	@FindBy(xpath= "//a[@href='/login']")
//	private static WebElement Loginlink;
	
	public enum Currency { INR, USD } 
	
	public static WebElement getLoginLink(){
		
		return driver.findElement(By.xpath("//a[@href='/login']")); 
			
	}
	
public static WebElement getCompanyField(){
		
		return driver.findElement(By.xpath("//input[@id='user_company_name']")); 
			
	}

public static WebElement getEmailField(){
	
	return driver.findElement(By.xpath("//input[@id='user_email']")); 
		
}

public static WebElement getPhoneNumberField(){
	
	return driver.findElement(By.xpath("//input[@id='user_phone_number']")); 
		
}

public static WebElement getPasswordField(){
	
	return driver.findElement(By.xpath("//input[@id='user_password']")); 
		
}

public static WebElement getPasswordConfirmationField(){
	
	return driver.findElement(By.xpath("//input[@id='user_password_confirmation']")); 
		
}

public static WebElement getRegisterButton(){
	
	return driver.findElement(By.xpath("//button[text()='Register']")); 
		
}

public static void selectCurrency(Currency currency){
	
	driver.findElement(By.xpath("//select[@id='currency_dropdown']")).click();
	driver.findElement(By.xpath("//select[@id='currency_dropdown']//option[text()='" + currency.toString() + "']")).click();
//	Select currList = new Select(driver.findElement(By.xpath("//select[@id='currency_dropdown']")));
//	currList.selectByVisibleText(currency.toString());
		
}

public static boolean verifyEmailConfirmationPage(){
	
	String emailConfiramtionHeader = driver.findElement(By.xpath("//h2")).getText();
	if(emailConfiramtionHeader.trim().equals("Email Confirmation")){
		return true;
	}
	else {
	return false;
	}
}

}
