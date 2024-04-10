package test;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonPageObjects;
import pages.initializeDriver;

public class amazontest {

    static WebDriver driver = null;

    @BeforeTest
    public void setup() {
        initializeDriver driverObject = new initializeDriver();
        driver = driverObject.initializeDriver();
    }

    @Test(priority = 1)
    public void verifySearchFunctionality() {
        driver.get("https://www.amazon.in/");
        AmazonPageObjects searchPageObj = new AmazonPageObjects(driver);
        searchPageObj.setTextInsearchBox("iphone");
        searchPageObj.clickSearchButton();
        // Add assertions to verify search results or other functionalities
    }

    @Test(priority = 2)
    public void verifyPageTitle() {
        driver.get("https://www.amazon.in/");
        String expectedTitle = "Amazon.in";
        String actualTitle = driver.getTitle();
        // You can add assertions here to verify the title
    }




    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
