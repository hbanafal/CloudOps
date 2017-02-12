package com.cloudops.pagelib;

import org.openqa.selenium.By;

import com.cloudops.genericlib.SolventSelenium;

public class MainDashboard extends SolventSelenium {
	
	public static void clickOnGetStartedButton(){
		
		driver.findElement(By.xpath("//div[@class='start']//span[text()='Get Started']")).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	driver.navigate().to(URL.);
		//waitForElementToAppear(driver.findElement(By.xpath("//div[@class='right cell']//button[text()='Continue']")));
	}

   public static void clickOnStartMigrationButton(){
		
		driver.findElement(By.xpath("//div[@class='start']//span[text()='Start Migration']")).click();		
	}
   
}
