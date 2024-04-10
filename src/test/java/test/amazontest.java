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

 @Test(priority = 5)
   public void verifyFilterByBrand() {
       driver.get("https://www.amazon.in/s?k=laptop");
       AmazonPageObjects searchPageObj = new AmazonPageObjects(driver);
      
       // Assuming there is a filter for selecting a specific laptop brand
       searchPageObj.setTextInsearchBox("laptop");
       searchPageObj.clickSearchButton();
       // Click on a specific brand filter (e.g., "Dell")
       WebElement dellFilter = driver.findElement(By.xpath("//span[text()='Dell']"));
       dellFilter.click();
    
       // Verify that all displayed products are Dell laptops
       List<WebElement> productTitles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
       for (WebElement title : productTitles) {
           assertTrue(title.getText().contains("Dell"), "Product title doesn't contain Dell");
       }
   }
   @Test(priority = 6)
   public void verifyAddToCart() {
       driver.get("https://www.amazon.in/s?k=iphone");
       AmazonPageObjects searchPageObj = new AmazonPageObjects(driver);
       searchPageObj.setTextInsearchBox("iphone");
       searchPageObj.clickSearchButton();
       // Assuming the first search result is the desired product
       WebElement firstProduct = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
       firstProduct.click();
       // Add the product to the cart
       WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
       addToCartButton.click();
       // Verify that the product is successfully added to the cart
       WebElement cartIcon = driver.findElement(By.id("nav-cart-count"));
       assertEquals(cartIcon.getText(), "1", "Product not added to the cart");
   }


    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
