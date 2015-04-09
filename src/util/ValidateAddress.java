package util;

public class ValidateAddress {
	
	public boolean verifyPostalCode(String streetName, String city, String province, String streetNameExp, String cityExp, String provinceExp){
		
		if  (streetName.equals(streetNameExp) && city.equals(cityExp) && province.equals(provinceExp))
			return true;
		else
			return false;
				
	}

}
