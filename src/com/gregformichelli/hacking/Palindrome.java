package com.gregformichelli.hacking;



public class Palindrome {
    
    private static final int ASCII_LOWERCASE_OFFSET = 32;

    public static boolean isPalindrone(String foo) {
        
        char [] fooChars = foo.toCharArray();
        char frontChar;
        char endChar;
        
        int endPtr = foo.length()-1;
        for(int beginPtr = 0; beginPtr < endPtr; ) {
            frontChar = fooChars[beginPtr];
            endChar = fooChars[endPtr];
            
            if( ! isAlphaNum(frontChar) ) {
                beginPtr++;
                continue;
            }
            if( ! isAlphaNum(endChar) ) {
                endPtr--;
                continue;
            }
            
            if( ! compareCharCaseInsensitive(frontChar, endChar) ) {
                return false;
            }
            
            endPtr--;
            beginPtr++;
        }
        
        return true;
    }
    
    public static boolean isPalindroneSimpler(String foo) {
        StringBuilder sb = new StringBuilder(foo.toLowerCase());
        return sb.reverse().equals(foo);
    }
    
    // Basically does a comparison and converts both to lower if needed
    public static boolean compareCharCaseInsensitive(char c1, char c2) {
        return(c1 == c2 || (int) c1 - ASCII_LOWERCASE_OFFSET == c2 || (int) c2 - ASCII_LOWERCASE_OFFSET == c1);
    }

    public static boolean isAlphaNum(char c) {
        
//        boolean isAlphaNum = false;
//        
//        if ((c >= 'a') && (c <= 'z')) {
//          isAlphaNum = true; // lowercase
//        }
//        else if ((c >= 'A') && (c <= 'Z')) {
//            isAlphaNum = true; // uppercase
//        }
//        else if ((c >= '0') && (c <= '9')) {
//            isAlphaNum = true; // numeric
//        }
        
        return Character.isLetterOrDigit(c);
    }
    
    
}