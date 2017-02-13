package com.cloudops.smoketests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import com.cloudops.genericlib.SolventSelenium;
import com.cloudops.pagelib.LoginPage;
import com.cloudops.pagelib.SignUpPage;
import com.cloudops.pagelib.SignUpPage.Currency;



public class LoginTest extends SolventSelenium {
	
	@Test
	public static void loginTest(){
		
		Reporter.log("Login with valid credentials on staging cloudops", true);
		Login("hemant.singh@sd2labs.com", "password");
		
		String expectedUserId = "Hemant Uncle";
		
		Reporter.log("Fetching Actual User Id Appearing on the Top Right corner of Home Page after successful login", true);
		String actualUserIdOnHomePage = LoginPage.getUserIdOnHomePage();
		
		Reporter.log("Actual User Id is " + actualUserIdOnHomePage, true);
		
		Reporter.log("Comparing Actual Id with Expected User Id", true);
		Assert.assertEquals(actualUserIdOnHomePage, expectedUserId, "Login successfully");
		
	}
	
	@Test
	public static void signUpTest(){
		
		int random = (int )(Math. random() * 100000);
		
		signUp("Hemant's Cloud Corp", "banafalhemant" + random + "@gmail.com", "9096993662", "password", Currency.INR);
		
		Assert.assertTrue(SignUpPage.verifyEmailConfirmationPage(), "Test is passed, User is redirected to Email Confirmation Page");
		
	}
	
	@Test
	public static void loginWithInvalidCred(){
		
		Reporter.log("Login with invalid credentials on staging cloudops", true);
		LoginWithInvalidCred("hemant.singh@sd2labs.com", "pasdfdsword");
		
		Assert.assertTrue(LoginPage.verifyInvalidCredentialsErrorMsg(), "Test is passed and user is not able to login with invalid credentials, Correct Message shown");
				
	}
	
	@Test
	public static void logoutTest(){
		
		Reporter.log("Login with valid credentials on staging cloudops", true);
		Login("hemant.singh@sd2labs.com", "password");
		logoutUser();
		
	}

}
