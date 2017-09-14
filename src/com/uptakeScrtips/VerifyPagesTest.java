package com.uptakeScrtips;
/**
* @author salohiddinnorqobilov
*these are all test cases throgh http://uptake.com website. needs to be verified.
*/
import static com.uptakeData.UrlPages.AboutUrl;
import static com.uptakeData.UrlPages.BeyondUptakeUrl;
import static com.uptakeData.UrlPages.BlogUrl;
import static com.uptakeData.UrlPages.HomeUrl;
import static com.uptakeData.UrlPages.IndustriesUrl;
import static com.uptakeData.UrlPages.NewsroomUrl;
import static com.uptakeData.UrlPages.ProductsUrl;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Uptake.Pages.UptakeHome;

import browsers.BrowserFactory;

public class VerifyPagesTest {
	static WebDriver driver = BrowserFactory.startBrowser("firefox", HomeUrl);
	UptakeHome homePage = PageFactory.initElements(driver, UptakeHome.class);
    public static Logger log = Logger.getLogger(VerifyPagesTest.class.getName());
	@Test(priority= 0,enabled = true)
	public void aboutPageTest(){
		homePage.goToAboutPage();
	
		log.info("About Page displayed");
		}
	@Test(priority= 1,enabled=true)
	public void productsPageTest(){
		homePage.goToProductsPage();
		
		log.info("Products Page displayed");
		}
	@Test(priority= 2,enabled=true)
	public void industriesPageTest(){
		homePage.goToIndustiesPage();
		
		log.info("Industries Page displayed");

		}
	@Test(priority= 3,enabled=true)
	public void newsroomPageTest(){
		homePage.goToNewsroomPage();
		
		log.info("Newsroom Page displayed");

		}
	@Test(priority= 4,enabled=true)
	public void beyondUptakePageTest() throws InterruptedException{
		homePage.goToBeyondUptakePage();
		
		log.info("Beyon.Uptake Page displayed");

		}
	@Test(priority= 5, enabled=true)
	public void blogPageTest() throws InterruptedException{
		homePage.goToBlogPage();
		
		log.info("Blog Page displayed");

	}

	@AfterClass
	public static void cleanUp(){
		driver.quit();
		log.info("Driver closed");
	}
}
		
