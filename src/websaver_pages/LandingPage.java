package websaver_pages;


import objectRepository.LandingPageObject;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	   WebDriver driver;	

	 //button
	@FindBy (xpath=LandingPageObject.webElementRegister)
	private WebElement buttonRegister;
	
	//This is a constructor that is called by either the New Operation or Page Factory pattern.
	 public  LandingPage(WebDriver driver){
			      this.driver = driver;
		         //This initElements method will create all WebElements
			      
			      System.out.println(driver.getTitle());
			      
			      //Verify the page is valid
			      if (driver.getTitle().equals("webSaver.ca | Save | Live | Give"))
			    	  PageFactory.initElements(driver, this);
			      else
			    	  //check how to catch the exception
			    	  throw new NoSuchWindowException ("this is not Landing Page");
			    	 			    	  
	 }
	
	
	public RegistrationPage doRegistration(){
		buttonRegister.click();
		/*
		 * Initiate Webelements
		It is better to give this responsability to Registartion Page
		 * 
		RegistrationPage regPage = PageFactory.initElements(driver, RegistrationPage.class);
		 * 
		 */
		return new RegistrationPage(driver);
		
	}

}
