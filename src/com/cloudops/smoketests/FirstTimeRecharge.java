package com.cloudops.smoketests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.cloudops.genericlib.SolventSelenium;
import com.cloudops.pagelib.DocuSign;
import com.cloudops.pagelib.MainDashboard;

public class FirstTimeRecharge extends SolventSelenium {
	
	@Test
	public static void rechargeForFirstTime(){
	
	Login("banafalhemant@gmail.com", "password");
	MainDashboard.clickOnGetStartedButton();
	waitForPageToLoad();
	DocuSign.signDocument();
	
	}
	
}
