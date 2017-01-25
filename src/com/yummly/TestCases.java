package com.yummly;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yummly.HomepageElements;

public class TestCases {
	
	private WebDriver driver;
	private String baseURL;
	HomepageElements homePage;
	
	@BeforeMethod
	public void beforeMethod(){
		
		driver = new FirefoxDriver();
		baseURL = "https://www.yummly.co";
		homePage = new HomepageElements(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@Test
	public void Test_A() throws Exception{
		
		driver.get(baseURL);
		homePage.verifyYummlyPageload();
		Thread.sleep(3000);
		System.out.println("Test_A completed");
		System.out.println("****************");
		
	}
	
	@Test
	public void Test_B() throws InterruptedException{
		
		driver.get(baseURL);
		Thread.sleep(3000);
		homePage.searchForRecipe("Chicken");
		homePage.clickSearchIcon();
		System.out.println("Titles of the first 5 Recipes are: ");
		List<WebElement> titles = driver.findElements(By.xpath("//div[@class='card-info']//preceding-sibling::h3"));
		List<WebElement> sublist = titles.subList(0, 5);
			for(WebElement firstFiveTitles : sublist){
				System.out.println(""+firstFiveTitles.getText());
				Thread.sleep(2000);
			}
		System.out.println("Test_B completed");
		System.out.println("****************");
	}    
   
	@Test
	public void Test_C() throws InterruptedException{
		
		driver.get(baseURL);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-reactid='245']")));
		homePage.clickRecipe();
	    System.out.println("The Ingredients for the Recipe are listed below: ");
	    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='IngredientLine']"));
	    	for(WebElement ingredients : elements){
	    		System.out.println(""+ingredients.getText());
	    		Thread.sleep(2000);
	    	}
	    System.out.println("Test_C completed");
	}
	
	@AfterMethod
	public void afterMethod(){
		
		driver.quit();
	}

}
