package test;

import org.openqa.selenium.WebDriver;


import pages.AmazonPageObjects;
import pages.initializeDriver;

public class AmazonSearchPgeTest  {
	static WebDriver driver=null;
   
	
    
	public static void main(String[] args) {
	    initializeDriver driverObjet=new initializeDriver();
		driver=driverObjet.initializeDriver();
		amazonSearchTest();
	}

	
	public static void amazonSearchTest() {
		 driver.get("https://www.amazon.in/");
	     AmazonPageObjects seachPageObj=new AmazonPageObjects(driver);
	     seachPageObj.setTextInsearchBox("iphone");
	     seachPageObj.clickSearchButton();
    
	}
}
