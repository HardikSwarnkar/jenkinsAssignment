package pages;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class initializeDriver {
	
	static WebDriver driver=null;

	
	public  WebDriver initializeDriver() {
		 driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     return driver;
	}

}
