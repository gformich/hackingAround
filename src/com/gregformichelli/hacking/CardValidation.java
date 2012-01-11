package com.gregformichelli.hacking;

public class CardValidation {
	
    public static boolean validLuhn10(String number) {
    	
    	if( number == null || number.trim().length() == 0 ) {
    		return false;
    	}
    	
        int currentNum=0;
        int sum=0;
 
        //iterate through the account number string
        //from right to left
        for (int i=0, k=number.length()-1; k>=0; i++,k--) {
 
        	char digit = number.charAt(k);
            // make sure the character is a digit
            if( ! Character.isDigit(digit)) {
            	return false;
            }
 
            currentNum=Character.digit(digit,10);
            //double the alternating digits per the formula
            if(i % 2 != 0){
                currentNum = currentNum*2;
                // if the digit is greater than 9 after doubling this trick
                // accommodates the LUHN's requirement to add EACH digit individually
                if(currentNum>9){
                    currentNum -= 9;
                }
            }
            sum += currentNum;//calculate the sum
        }
        
        //if the sum is divisible by 10 the number is valid
        return (sum % 10 == 0);
    }
    
    public static boolean validLuhn10(long cardNum) {
    	return validLuhn10( Long.toString(cardNum) );
    }

}
