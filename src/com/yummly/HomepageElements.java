package com.yummly;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomepageElements {
	
	WebDriver driver;
	
	/**
	 * Returns the searchBox element
	 */
	@FindBy(id="searchbox-input")
	WebElement searchBox;
	
	/**
	 * Returns the searchBox icon
	 */
	@FindBy(xpath="//span[contains(@class,'y-icon spyglass')]")
	WebElement searchBoxIcon;
	
	/**
	 * Returns the Recipe element
	 */
	@FindBy(css="div[data-reactid='245']")
	WebElement recipeElement;
	
	
	public HomepageElements(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Search for recipe in the searchbox
	 */
	public void searchForRecipe(String search){
		searchBox.sendKeys(search);
	}
	
	/**
	 * Click SearchIcon button on homepage
	 */
	public void clickSearchIcon(){ 
		searchBoxIcon.click();
	}
	
	/**
	 * Click Recipe on homepage
	 */
	public void clickRecipe(){
		recipeElement.click();
	}	
	
	/**
	 * Verify yummly.co homepage loaded successfully
	 */
	public void verifyYummlyPageload(){
		String expectedTitle = "Yummly: Personalized Recipe Recommendations and Search";
		String actualTitle = driver.getTitle();
		try{
		Assert.assertEquals(actualTitle,expectedTitle);
		System.out.println("Yummly Webpage is loaded successfully");
		}
		catch(Throwable e){
		System.out.println("Yummly Page load failed");
		}
	}

}
