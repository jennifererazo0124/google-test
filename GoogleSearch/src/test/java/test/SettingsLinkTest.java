package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
import pages.ResultsPage;

public class SettingsLinkTest {
	
	WebDriver driver = null;
	GoogleSearchPage googleSearchPage;
	ResultsPage resultsPage;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
	    options.addArguments("--lang=en-GB");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void settingsLinkTest() {
		
		googleSearchPage = new GoogleSearchPage(driver);
		googleSearchPage.search("QA");
		resultsPage = new ResultsPage(driver);
		if(resultsPage.searchSettingsLink()) {
			System.out.println("Si");
		}
		else{
			System.out.println("No");
		}
	}
	
	@AfterTest
	public void tearDown() {
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
}
