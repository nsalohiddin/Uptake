package com.Uptake.Pages;

import static com.uptakeData.UrlPages.AboutUrl;
import static com.uptakeData.UrlPages.BeyondUptakeUrl;
import static com.uptakeData.UrlPages.BlogUrl;
import static com.uptakeData.UrlPages.IndustriesUrl;
import static com.uptakeData.UrlPages.NewsroomUrl;
import static com.uptakeData.UrlPages.ProductsUrl;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * @author salohiddinnorqobilov
 *this is using Page Object Model using Page Factory 
 */
public class UptakeHome {


	WebDriver driver;
	public UptakeHome(WebDriver localdriver){
		this.driver=localdriver;
	}
// Locating web pages
	//About page
	@FindBy(how=How.XPATH,using=".//*[@id='header']/div[1]/nav/a[1]") 
	//cash lookup annotation first checks the memory and then moves to next element
	@CacheLookup
	WebElement AboutPage;
	//Products page
	@FindBy(how=How.XPATH,using=".//*[@id='header']/div[1]/nav/a[2]")
	@CacheLookup
	WebElement PruductsPage;
	
	//Industries page
	@FindBy(how=How.XPATH,using=".//*[@id='header']/div[1]/nav/a[3]") 
	@CacheLookup
	WebElement  IndustriesPage;
	// Newsroom page
	@FindBy(how=How.LINK_TEXT,using="Newsroom") 
	@CacheLookup
	WebElement NewsroomPage;
	// Beyond.uptake page
	@FindBy(how=How.LINK_TEXT,using="Beyond.Uptake") 
	@CacheLookup
	WebElement BeyondUptakePage;
	// Blog page
	@FindBy(how=How.XPATH,using=".//*[@id='header']/div[1]/nav/a[6]") 
	@CacheLookup
	WebElement BlogPage;
	
	
	
	
	
	// these methods will click above elements when they called
	public void goToAboutPage(){
		AboutPage.click();
		String currentAboutUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentAboutUrl);
		Assert.assertEquals(currentAboutUrl, AboutUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	public void goToProductsPage(){
		
		PruductsPage.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentUrl);
		Assert.assertEquals(currentUrl, ProductsUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void goToIndustiesPage(){
		IndustriesPage.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentUrl);
		Assert.assertEquals(currentUrl, IndustriesUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void goToNewsroomPage(){
		NewsroomPage.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentUrl);
		Assert.assertEquals(currentUrl, NewsroomUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void goToBeyondUptakePage() throws InterruptedException{
		BeyondUptakePage.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate= windows.iterator();
		while(iterate.hasNext()){
			String childWindow =iterate.next();
			
			if(!parentWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				Thread.sleep(5000);
				String currentUrl = driver.getCurrentUrl();
				System.out.println("The current url is: " + currentUrl);
				Assert.assertEquals(currentUrl, BeyondUptakeUrl);
				driver.close();
				break;
			}
		}	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void goToBlogPage() throws InterruptedException{
		BlogPage.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate= windows.iterator();
		while(iterate.hasNext()){
			String childWindow =iterate.next();
			if(!parentWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				Thread.sleep(5000);
				String currentUrl = driver.getCurrentUrl();
				System.out.println("The current url is: " + currentUrl);
				Assert.assertEquals(currentUrl, BlogUrl);
				break;
			}
		}
		
	}

    
	
}

