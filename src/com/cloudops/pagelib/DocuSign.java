package com.cloudops.pagelib;

import org.openqa.selenium.By;

import com.cloudops.genericlib.SolventSelenium;

public class DocuSign extends SolventSelenium {
	
	public static void signDocument() {
		
		driver.findElement(By.xpath("//div[@class='right cell']//button[text()='Continue']")).click();
		driver.findElement(By.xpath("//button[@id='navigate-btn']//span[text()='Start']")).click();
		driver.findElement(By.xpath("//button[@id='navigate-btn']//span[text()='Sign']")).click();
	    driver.findElement(By.xpath("//div[@class='signature-tab-content']//div[text()='Sign']")).click();
	    driver.findElement(By.xpath("//button[@id='end-of-document-btn-finish' and text() = 'Finish']")).click();
		
	}
	

}
