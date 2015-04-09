package data;

import org.testng.annotations.DataProvider;

public class Data_Provider {

	@DataProvider (name="changePasswordDataProvider")
	public static Object [] [] getData(){
		Object data [] [] = new Object [2] [3];
		
		data [0] [0] = "Xy123456";
		data [0] [1] = "Ab123456";
		data [0] [2] = "Ab123456";
		
		data [1] [0] = "Xy123456";
		data [1] [1] = "Mn123456";
		data [1] [2] = "MN123456";
		
		return data;
		
	}
}
