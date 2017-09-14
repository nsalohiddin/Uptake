package com.uptakeScrtips;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.uptakeData.OpenPositionsPage;

import static com.uptakeData.UrlPages.HomeUrl;
import static com.uptakeData.UrlPages.JobUrl;

import browsers.BrowserFactory;

public class JobSearchUptake {
	static WebDriver driver = BrowserFactory.startBrowser("firefox", HomeUrl);
	OpenPositionsPage JobsPage = PageFactory.initElements(driver, OpenPositionsPage.class);
    public static Logger log = Logger.getLogger(JobSearchUptake.class.getName());

	@Test
	public void verifyJob() throws InterruptedException{
		JobsPage.goToOpenPositions();
		//verifying the current url with expected jobUrl which is Automation Engineer
        Assert.assertEquals(driver.getCurrentUrl(), JobUrl);
        
	}

}
