package pages;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPageObjects {
	
	WebDriver driver=null;
	
	//locators for search box and button

	By textbox_search = By.id("twotabsearchtextbox");
	
	By button_seaarch=By.id("nav-search-submit-button");
	
	//constructor to get the driver from other class
	
	public AmazonPageObjects(WebDriver driver) {
		
		this.driver=driver;
	}
	
	//ACTIONS
	public void setTextInsearchBox(String text) {
		
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(button_seaarch).sendKeys(Keys.RETURN);
	}
	
	
	
	
}

