package com.registrationonline.customerregistration.utilities;

public class ValidationUtils
{
	public static Boolean isIdentityValid( Long idNumber){
		char[] idCharArray = idNumber.toString().toCharArray();
		int sum = 0;
		for (int i = 0; i < idCharArray.length - 1; i++) {
			int digit = Character.getNumericValue(idCharArray[i]);
			if ((i % 2) == 0) {
				sum += digit;
			} else {
				sum += digit < 5 ? digit * 2 : digit * 2 - 9;
			}
		}
		int checkdigit = Character.getNumericValue(idCharArray[idCharArray.length - 1]);
		int compdigit = (sum * 9) % 10;
		return checkdigit == compdigit;
	}

}
