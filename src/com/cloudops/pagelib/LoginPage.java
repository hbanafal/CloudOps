package com.cloudops.pagelib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cloudops.genericlib.SolventSelenium;

public class LoginPage extends SolventSelenium {
	
public static WebElement getUsername(){
		
		return driver.findElement(By.xpath("//input[@id='user_email']")); 
			
	}

public static WebElement getPassword(){
	
	return driver.findElement(By.xpath("//input[@id='user_password']")); 
		
}

public static WebElement getLoginButton(){
	
	return driver.findElement(By.xpath("//button[text()='Login']")); 
		
}

public static WebElement getLoginFormHeader(){
	
	return driver.findElement(By.xpath("//div//h2[text()='Account Login']")); 
		
}



public static String getUserIdOnHomePage(){
	return driver.findElement(By.xpath("//button[@class='dropdown-toggle']//div[@class='label']//span[@class='wel']")).getText();
	
}

public static boolean verifyInvalidCredentialsErrorMsg(){
    return driver.findElement(By.xpath("//div[@id='alert']")).getText().equals("Invalid credentials");
}

	

}
