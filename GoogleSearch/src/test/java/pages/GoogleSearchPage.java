package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	WebDriver driver = null;
	By searchBoxLocator = By.name("q");
	
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	public void search(String searchTerm) {
		
		WebElement searchBox = driver.findElement(searchBoxLocator);
		
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
		searchBox.submit();
	}
}
