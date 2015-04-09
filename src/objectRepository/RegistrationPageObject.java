package objectRepository;

public class RegistrationPageObject {
	
	//Registration Page's elements
	
	//Input elements
	public static final String webElementInputFirstName = "//input[@id='User_firstName']";
	public static final String webElementInputLastName = "//input[@id='User_lastName']";
	public static final String webElementInputEmail = "//input[@id='User_email_first']";
	public static final String webElementInputConfirmationEmail = "//input[@id='User_email_second']";
	public static final String webElementInputPassword = "//input[@id='User_password_first']";
	public static final String webElementInputConfirmationPassword = "//input[@id='User_password_second']";
	public static final String webElementInputPostalCodeBox1 = "//input[@id='pcode1']";
	public static final String webElementInputPostalCodeBox2 = "//input[@id='pcode2']";
	public static final String webElementInputStreetName ="//input[@id='User_streetName']";
	public static final String webElementInputStreetNumber = "//input[@id='User_streetNumber']";
	public static final String webElementInputAppNumber = "//input[@id='User_apartmentNumber']";
	public static final String webElementInputCity = "//input[@id='User_city']";
	public static final String webElementInputPOBox = "//input[@id='User_poBox']";
	public static final String webElementInputRuralRoute = "//input[@id='User_ruralRoute']";
	
	
	//Select elements
	public static final String webElementSelectStreetNameDropDown = "//select[@id='streetName_dropdown']";
	public static final String webElementSelectProvince = "//select[@id='User_province']";
	public static final String webElementSelectBdayMonth = "//select[@id='User_bdayMonth']";
	public static final String webElementSelectBdayYear = "//select[@id='User_bdayYear']";
	
	//Checkbox elements
	public static final String webElementCheckboxPO = "//input[@id='pobox']";
	public static final String webElementCheckboxRrn = "//input[@id='rrr']";
	public static final String webElementCheckboxUserAgree = "//input[@id='User_agreement']";
	public static final String webElementCheckboxWebOptin  = "//input[@id='User_is_websaver_optin']";
	public static final String webElementCheckboxDifAdd = "//input[@id='difadd']";
	
	//Radio-Button elements
	public static final String webElementRadiobuttonMale = "//input[@id='User_gender_0']";
	public static final String webElementRadiobuttonFemale = "//input[@id='User_gender_1']";
	
	//Link elements
	public static final String webElementLinkChangeLocation = "//a[@class='change_address']";
	public static final String webElementLinkTermUser = "//a[@href='termsandconditions']";
	public static final String webElementLinkFirstPrivacyPolicy  = "//a[@href='privacypolicy']";
	public static final String webElementLinkSecondPrivacyPolicy  = "//a[@href='privacypolicy.php']";
	
	//Button
	public static final String webElementSubmit = "//button[@id='User_submit_btn']";
	
}
