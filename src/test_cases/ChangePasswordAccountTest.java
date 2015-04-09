package test_cases;

import org.junit.Assert;
import org.testng.annotations.Test;

import data.Data_Provider;

public class ChangePasswordAccountTest {
	
	
	@Test(priority=1)
	public void testLogin(){
		Assert.assertEquals("a","A");
		System.out.println("I am in Login");
	}
	
	@Test(priority=2, dependsOnMethods={"testLogin"})
	public void testChangePassword(){
		System.out.println("I am change password");
	}
	
	
	@Test(priority=3, dependsOnMethods={"testLogin"})
	public void testLogout(){
		System.out.println("I am in Logout");
	}
	
	
	@Test(dataProviderClass=Data_Provider.class, dataProvider="getData")
	public void SuccessToChangeUserAccountPassword(String oldPassword, String newPassword, String confirmNewPassword){
		System.out.println(oldPassword);
		System.out.println(newPassword);
		System.out.println(confirmNewPassword);
				
	}

	
}
