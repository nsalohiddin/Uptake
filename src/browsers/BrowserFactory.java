package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	private static WebDriver driver;
	public static WebDriver startBrowser(String browserName, String url){
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",	 "//Users//salohiddinnorqobilov//Desktop//Drivers//geckodriver");

			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",	 "//Users//salohiddinnorqobilov//Desktop//Drivers//chromedriver");

			driver=new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("IE")){
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
		
	}

}
