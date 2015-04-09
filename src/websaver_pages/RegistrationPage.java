package websaver_pages;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import objectRepository.RegistrationPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class RegistrationPage {
	
	 WebDriver driver;
	
	//inputs
	@FindBy(xpath=RegistrationPageObject.webElementInputFirstName)
	private WebElement inputFirstName;
	@FindBy(xpath=RegistrationPageObject.webElementInputLastName)
	private WebElement inputLastName;
	@FindBy(xpath=RegistrationPageObject.webElementInputEmail)
	private WebElement inputEmail;
	@FindBy(xpath=RegistrationPageObject.webElementInputConfirmationEmail)
	private WebElement inputConfirmEmail;
	@FindBy (xpath=RegistrationPageObject.webElementInputPassword)
	private WebElement inputPassword;
	@FindBy (xpath=RegistrationPageObject.webElementInputConfirmationPassword)
	private WebElement inputConfirmPassword;
	@FindBy (xpath=RegistrationPageObject.webElementInputPostalCodeBox1)
	private WebElement inputPostalCode1;
	@FindBy (xpath=RegistrationPageObject.webElementInputPostalCodeBox2)
	private WebElement inputPostalCode2;
	@FindBy (xpath=RegistrationPageObject.webElementInputStreetName)
	private WebElement inputStreetName;
	@FindBy (xpath=RegistrationPageObject.webElementInputStreetNumber)
	private WebElement inputAddressNumber;
	@FindBy (xpath=RegistrationPageObject.webElementInputAppNumber)
	private WebElement inputAppNumber;
	@FindBy (xpath=RegistrationPageObject.webElementInputCity)
	private WebElement inputCity;
	@FindBy (xpath=RegistrationPageObject.webElementInputPOBox)
	private WebElement inputPoBox;
	@FindBy (xpath=RegistrationPageObject.webElementInputRuralRoute)
	private WebElement inputRuralRoute;
	
	//checkboxes
	@FindBy (xpath=RegistrationPageObject.webElementCheckboxDifAdd)
	private WebElement checkboxDifAddress;
	@FindBy (xpath=RegistrationPageObject.webElementCheckboxPO)
	private WebElement checkboxPoBoxNumber;
	@FindBy (xpath=RegistrationPageObject.webElementCheckboxRrn)
	private WebElement checkboxRuralNumber;
	@FindBy (xpath=RegistrationPageObject.webElementCheckboxUserAgree)
	private WebElement checkboxUserAgree;
	@FindBy (xpath=RegistrationPageObject.webElementCheckboxWebOptin)
	private WebElement checkboxWebsaverOptin;
	
	//radio-buttons
	@FindBy (xpath=RegistrationPageObject.webElementRadiobuttonFemale)
	private WebElement radioFemale;
	@FindBy (xpath=RegistrationPageObject.webElementRadiobuttonMale)
	private WebElement radioMale;
	
	//selects
	@FindBy (xpath=RegistrationPageObject.webElementSelectStreetNameDropDown)
	private WebElement selectStreetName;
	@FindBy (xpath=RegistrationPageObject.webElementSelectProvince)
	private WebElement selectProvince;
	@FindBy (xpath=RegistrationPageObject.webElementSelectBdayMonth)
	private WebElement selectMonth;
	@FindBy (xpath=RegistrationPageObject.webElementSelectBdayYear)
	private WebElement selectYear;
	
	//links
	@FindBy (xpath=RegistrationPageObject.webElementLinkChangeLocation)
	private WebElement linkNewLocation;
	@FindBy (xpath=RegistrationPageObject.webElementLinkTermUser)
	private WebElement linkTermUser;
	@FindBy (xpath=RegistrationPageObject.webElementLinkFirstPrivacyPolicy)
	private WebElement linkFirstPolicy;
	@FindBy (xpath=RegistrationPageObject.webElementLinkSecondPrivacyPolicy)
	private WebElement linkSecPolicy;
	
	//button
	@FindBy (xpath=RegistrationPageObject.webElementSubmit)
	private WebElement buttonSubmit;
	
	
	public RegistrationPage (WebDriver driver){
	      this.driver = driver;
          //This initElements method will create all WebElements.
	      //All the WebElelemnts are now alive!!
	      
	      //Verify the page is valid
	      if (driver.getTitle().equals("webSaver.ca webSaver.ca - Registration"))
	    	  PageFactory.initElements(driver, this);
	      else
	    	  //check how to catch the exception
	    	  throw new NoSuchWindowException ("this is not Registration Page");
	    
}
	
	public SurveyPage registerUser(Hashtable<String,String>  userData){
		//complete the form here
		
		//implicit wait - global timeout
	    driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
		
	    // input(userInfo.get("firstName"), regProp.getProperty("input_firstName"));
		
		inputFirstName.sendKeys(userData.get("xlsFirstName"));
		inputLastName.sendKeys(userData.get("xlsLastName"));
		inputEmail.sendKeys(userData.get("xlsEmail"));
		inputConfirmEmail.sendKeys(userData.get("xlsConfirmationEmail"));
		inputPassword.sendKeys(userData.get("xlsPassword"));
		inputConfirmPassword.sendKeys(userData.get("xlsConfirmationPassword"));
		inputPostalCode1.sendKeys(userData.get("xlsPostalBox1"));
		inputPostalCode2.sendKeys(userData.get("xlsPostalBox2"));
		
		driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
		
		//Validate Address according to Postal Code Canada
		/*
		ValidateAddress onValidateAddress = new ValidateAddress();
		
		if (!validateAddress.verifyPostalCode("streetName", "city", "province", "streetNameExp", "cityExp", "provinceExp"))
		{
			//trouble locating
			if (!checkboxDifAddress.isEnabled()){
				checkboxDifAddress.click();
				Assert.assertTrue(inputStreetName.isEnabled());
				inputStreetName.sendKeys("1010 Bellavista");	
			}else
				System.out.println("streetName field should be disable");
			
		}else{
			Assert.assertFalse(inputCity.isEnabled());
			Assert.assertFalse(selectProvince.isEnabled());
		}
		*/
		inputAddressNumber.sendKeys(userData.get("xlsAddressNumber"));
		inputAppNumber.sendKeys(userData.get("xlsAparmentNumber"));
		
			
	/*	if ("xlsPoBox" == "N"){
			Assert.assertFalse(checkboxPoBoxNumber.isEnabled());
			checkboxPoBoxNumber.click();
			inputPoBox.sendKeys("090909");
			Assert.assertFalse(checkboxRuralNumber.isEnabled());
		}
		if ("xlsRuralRoute" == "Yes"){
			Assert.assertFalse(checkboxRuralNumber.isSelected());
			Assert.assertFalse(inputRuralRoute.isEnabled());
			checkboxRuralNumber.click();
			Assert.assertTrue(inputRuralRoute.isDisplayed());
			Assert.assertFalse(checkboxPoBoxNumber.isSelected());
			Assert.assertFalse(inputPoBox.isDisplayed());
		}
		
		*/
		new Select(selectMonth).selectByVisibleText(userData.get("xlsBdMonth"));
		
		System.out.println(userData.get("xlsBdYear"));
		new Select(selectYear).selectByVisibleText(userData.get("xlsBdYear"));

		
	
		if (userData.get("xlsGender").equals('F'))
			radioFemale.click();
		else
			radioMale.click();
		
		if (userData.get("xlsOptPrivacy").equals("Y"))
			checkboxUserAgree.click();	
				 
	    if (userData.get("xlsOptNotification").equals("Y"))
			checkboxWebsaverOptin.click();
		
	    
		return submitRegistration(); 
	}
	
/*	public boolean validStreetName(){
		String  canadaPostAddress = "dfsdf";
		
		if (streetName.getText() == canadaPostAddress)
			return true;
		else
			return false;
	}
	*/
	public RegistrationPage submitRegistrationExpectingFailure(){
		//make the invalid registration here
		return null;
	}
	
	
	public void clickSubmitButton(){
		buttonSubmit.click();
	}
	
	public SurveyPage submitRegistration(){
		//submit registration here
		clickSubmitButton();
    	SurveyPage surveyPage = PageFactory.initElements(driver, SurveyPage.class);
		return surveyPage;
		
	}
	
	public String getErrorMessageForFirstNameEmpty(){
		return  driver.findElement(By.cssSelector("div.msgerror")).getText();
	}
	
	public String getErrorMessageForLastNameEmpty(){
		return  driver.findElement(By.xpath("//form/div[2]/div/div")).getText();
	}
	
	public String getErrorMessageForEmailEmpty(){
		return  driver.findElement(By.xpath("//form/div[3]/div/div")).getText();
	}
	
	public String getErrorMessageForPasswordEmpty(){
		return  driver.findElement(By.xpath("//form/div[5]/div/div")).getText();
	}
	
	public String getErrorMessageForPostalCodeEmpty(){
		return  driver.findElement(By.xpath("//div[@id='pcode_shattered_holder']/div/span/div")).getText();
	}
	
	public String getErrorMessageForMonthOfBirthNotSlected(){
		return  driver.findElement(By.xpath("//div[9]/div/div/div")).getText();
	}
	
	public String getErrorMessageForYearOfBirthNotSelected(){
		return  driver.findElement(By.xpath("//div[9]/div/div[2]/div")).getText();
	}
	
	public String getErrorMessageForGenderNotSelected(){
		return  driver.findElement(By.xpath("//div[10]/div/div[2]")).getText();
	}
	
	public String getErrorMessageForPrivacyStatementNotChecked(){
		return  driver.findElement(By.cssSelector("div.col-xs-12 > div.msgerror")).getText();
	}
	
	
	
	

	
	
	
 
	
	
	
}
