package test_cases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import testng_listeners.ErrorUtil;
import util.TestUtil;
import util.Xls_Reader;
import websaver_pages.*;

public class RegistrationTest {
	 WebDriver driver = null;

	 @DataProvider
	  public Object[][] getData(){
		// return TestUtil.getData("RegistrationWithValideData", new Xls_Reader(System.getProperty("user.dir")+"/src/data/websaverUserRegistration.xlsx"));
		 //System.out.println("System.getProperty("user.dir")");
		 
		    String currentDir = System.getProperty("user.dir");
	        System.out.println("Current dir using System:" +currentDir);
	        System.out.println(currentDir+"/src/data/websaverUserRegistration.xlsx");
	        return TestUtil.getData("RegistrationWithValideData", new Xls_Reader(System.getProperty("user.dir")+"/src/data/websaverUserRegistration.xlsx"));
		
			 //return TestUtil.getData("RegistrationWithValideData", new Xls_Reader("C:\\Users\\ricardo.oquenes\\workspace\\Heinz\NewYearNewYou\\WebSaverClub/src/data/websaverUserRegistration.xlsx"));
	 }

	 @Test(dataProvider="getData")
	  public void SuccessToRegisterUsersForAllProvinces(Hashtable<String,String> data){
		
		  System.out.println(data.get("RunMode")+" -- "+data.get("xlsFirstName")+" -- "+data.get("xlsLastName") +" -- "+data.get("xlsEmail"));
		 
		  LandingPage onLandingPage =  new LandingPage(driver);
		  /*
		  Using PageFactory here, LandingPage constructor only needs to set this.driver = driver  
		  LandingPage onLandingPage = PageFactory.initElements(driver, LandingPage.class);
		    */
	       RegistrationPage  onRegistrationForm = onLandingPage.doRegistration();
		   //onRegistrationForm.registerUser(data);
	       SurveyPage onSurveyPage = onRegistrationForm.registerUser(data);
		   
		   //whether the driver is on SurveyPage means the registration was successful!!!
		   try{
			  //System.out.println(driver.getTitle());
			  //Assert.assertEquals(driver.getTitle(),"SurveyPage");
		      Assert.assertEquals(driver.getCurrentUrl(),"http://stg-club.websaver.ca/app_stage.php/en/survey/");
		   }catch (Throwable t ) {
			      System.out.println("Registration Not Succeed");
				  ErrorUtil.addVerificationFailure(t);
			 }
	 }
	 
	 @Test(priority=1)
	 public void FailToSubmitRegistrationIfMandatoryFieldsAreMissing(){
		  //SoftAssert s_assert = new SoftAssert();
		 // String Actualtext; 
		 
		 LandingPage onLandingPage =  new LandingPage(driver);
		  RegistrationPage  onRegistrationForm = onLandingPage.doRegistration();
		  onRegistrationForm.clickSubmitButton();
		  
		 //Assert.assertTrue(onRegistrationForm.getErrorMessageForFirstNameEmpty().contains("Please enter your First Name."));
		  
		  try{
		  Assert.assertEquals("Please enter your First Name.LAUNCH ERROR", onRegistrationForm.getErrorMessageForFirstNameEmpty());
		  }catch (Throwable t ) {
			  System.out.println("First Name Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
	
		  try{
		 Assert.assertEquals("Please enter your Last Name.", onRegistrationForm.getErrorMessageForLastNameEmpty());
		  }catch (Throwable t ) {
			  System.out.println("Last Name Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
		 
		  try{		 
		 Assert.assertEquals("Please enter an e-mail address.LAUNCH ERROR", onRegistrationForm.getErrorMessageForEmailEmpty());
		  }catch (Throwable t ) {
			  System.out.println("e-mail address Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
		 
		  try{
		 Assert.assertEquals("Please enter your password.", onRegistrationForm.getErrorMessageForPasswordEmpty());
		  }catch (Throwable t ) {
			  System.out.println("pasword address Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
		 
		  try{
		 Assert.assertEquals("Please enter a valid postal code.", onRegistrationForm.getErrorMessageForPostalCodeEmpty());
		  }catch (Throwable t ) {
			  System.out.println("postal code Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
		 
		 try{
		 Assert.assertEquals("Please select your month of birth.", onRegistrationForm.getErrorMessageForMonthOfBirthNotSlected());
		 }catch (Throwable t ) {
			  System.out.println("Month of birth Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
		 
		try{
		 Assert.assertEquals("Please select your year of birth.", onRegistrationForm.getErrorMessageForYearOfBirthNotSelected());
		}catch (Throwable t ) {
			  System.out.println("Year of birth Error");
			  ErrorUtil.addVerificationFailure(t);
		  }
		
		try{
		 Assert.assertEquals("Please select your gender.", onRegistrationForm.getErrorMessageForGenderNotSelected());
		}catch (Throwable t ) {
			  System.out.println("Gender Error");
			  ErrorUtil.addVerificationFailure(t);
		  } 
		 
		try{
		 Assert.assertEquals("Please agree to our terms of service and privacy statement.", onRegistrationForm.getErrorMessageForPrivacyStatementNotChecked());
		}catch (Throwable t ) {
			  System.out.println("Privacy Statement Error");
			  ErrorUtil.addVerificationFailure(t);
		  } 
		 
 }
	 
	 @Test(priority=2)
	 public void UserNotSubmittedIfFeldsAreInvalid(){
		 
		 
	 }
	 
	 @Test(priority=3)
	 public void UserNotSubmittedIfPasswordAndConfirmationPassowrdAreDifferent(){
		 
	 }
	 
	 
	
	 
	 @Test
	 public void submitRegistrationWithAddressNotFound(){
		 
	 }
	 
	 @Test
	 public void submitRegistrationWithDifferentAddress(){
		 
	 }
	 
	 
	 
	 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("open browser");
	  driver = new FirefoxDriver();
	  String baseUrl = "http://dev_ws:dev@stg-club.websaver.ca";
	  driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
	  driver.get(baseUrl + "/app_stage.php");
	  //driver.get(http://username:password@www.basicauthprotected.com/);
	
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

/*
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  */
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
