package com.cloudops.smoketests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.cloudops.genericlib.SolventSelenium;
import com.cloudops.pagelib.LoginPage;
import com.cloudops.pagelib.SignUpPage;
import com.cloudops.pagelib.SignUpPage.Currency;



public class LoginTest extends SolventSelenium {
	
	@Test(enabled= false)
	public static void loginTest(){
		
		Reporter.log("Login with valid credentials on staging cloudops", true);
		Login("hemant.singh@sd2labs.com", "password");
		
		String expectedUserId = "hemant.singh";
		
		Reporter.log("Fetching Actual User Id Appearing on the Top Right corner of Home Page after successful login", true);
		String actualUserIdOnHomePage = LoginPage.getUserIdOnHomePage();
		
		Reporter.log("Actual User Id is " + actualUserIdOnHomePage, true);
		
		Reporter.log("Comparing Actual Id with Expected User Id", true);
		AssertJUnit.assertEquals(expectedUserId, actualUserIdOnHomePage, "Login successfully");
		
	}
	
	@Test(enabled= false)
	public static void signUpTest(){
		
		signUp("Hemant's Cloud Corp", "banafalhemant@gmail.com", "9096993662", "password", Currency.INR);
		if(SignUpPage.verifyEmailConfirmationPage())
		{
					Reporter.log("Test is passed, User is redirected to Email Confirmation Page", true);
		}
		else
		{
			Reporter.log("Test Failed", true);
			
		}
	}
	
	@Test(enabled= false)
	public static void loginWithInvalidCred(){
		
		Reporter.log("Login with valid credentials on staging cloudops", true);
		Login("hemant.singh@sd2labs.com", "pasdfdsword");
		if(LoginPage.verifyInvalidCredentialsErrorMsg())
		{
			Reporter.log("Test is passed and user is not able to login with invalid credentials, Correct Message shown", true);
		}
		else {
			Reporter.log("Test is failed, Correct Message is not shown", true);
		}
		
	}
	
	@Test
	public static void logoutTest(){
		
		Reporter.log("Login with valid credentials on staging cloudops", true);
		Login("hemant.singh@sd2labs.com", "password");
		logoutUser();
		
	}

}
