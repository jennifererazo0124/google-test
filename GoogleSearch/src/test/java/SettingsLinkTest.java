import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SettingsLinkTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	   
		options.addArguments("--test-type");
	    options.addArguments("--lang=en-GB");
	    driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		By settingsLinkLocator = By.linkText("Settings");
		
		WebElement searchBox = driver.findElement(By.name("q"));
	
		searchBox.clear();
		searchBox.sendKeys("QA");
		searchBox.submit();
		
		//Thread.sleep(3000);
		if(driver.findElement(settingsLinkLocator).isDisplayed()) {
			System.out.println("Si");
		}
		else {
			System.out.println("No");
		}
		
		
	}
}
