package com.uptakeData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OpenPositionsPage {
	
	WebDriver driver;
	public OpenPositionsPage(WebDriver localdriver1){
		this.driver=localdriver1;
	}
	// Open Positions button
		@FindBy(how=How.XPATH,using=".//*[@id='home']/div[4]/div/div[1]/div/button") 
		@CacheLookup
		WebElement OpenPositions;
		
		// Select all departments drop down
		@FindBy(how=How.NAME,using="departments-select") 
		@CacheLookup
		WebElement DepartSel;
		
		//Select all offices drop down
		@FindBy(how=How.ID,using="offices-select") 
		@CacheLookup
		WebElement Offices;
		
		@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/section[5]/div[1]/a") 
		@CacheLookup
		WebElement JobResult;
		
		
		
		public void goToOpenPositions() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //Scrolling untill  the button appears
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", OpenPositions);
	        Actions act = new Actions(driver);
	        act.moveToElement(OpenPositions).click().build().perform();
	        act.release();
	        
	        Thread.sleep(5000);
	        
	        Select select1 = new Select(DepartSel);
	        	
	        	 select1.selectByVisibleText("Engineering");
	        
	        Select select2 = new Select(Offices);
	        select2.selectByValue("10661");
	        Thread.sleep(5000);
	       JobResult.click();
	    	}
	
}
