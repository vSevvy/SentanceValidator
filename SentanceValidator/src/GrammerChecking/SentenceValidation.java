package GrammerChecking;

import java.util.Scanner;

/**
This class validates a sentence based on the below rules.
•	String starts with a capital letter.
•	String has an even number of quotation marks.
•	String ends with one of the following sentence termination characters: ".", "?", "!"
•	String has no period characters other than the last character.
•	Numbers below 13 are spelled out (” one”, “two”, "three”, etc…).
@author Evan McCullough
@version 1.0
 */

public class SentenceValidation {

    /**
     * This method calls all other methods to check if a sentence is valid
     * @param sent  - the input from the main function
     * @return the allTrue variable
     */
    public static boolean isSentence(String sent){
        boolean hasCap = isFirstIsCap(sent);
        boolean evenQuotes = isEvenQuotes(sent);
        boolean hasTermOp = hasTerminator(sent);
        boolean hasOnePeriod = isOnePeriod(sent);
        boolean noLowInt = isNoLowNum(sent);

        // boolean array to hold all bool values
        boolean[] allMethods = {
                hasCap, evenQuotes, hasTermOp, hasOnePeriod , noLowInt
        };

        // This checks if all the bool values within the array are true, if one is false it the entire method returns false
        boolean allTrue=true;
        for(int loop=0; loop<allMethods.length;++loop)
        {
            if(allMethods[loop] == false)
            {
                allTrue = false;
                break;
            }
        }
        return allTrue;
    }

    /**
     * This method checks if the first character in the string is capitalised
     * @param s - the input from the main function
     * @return true if it has a capital letter at the start, false if otherwise
     */
    public static boolean isFirstIsCap(String s) {
        boolean hasCap = false;
        if(Character.isUpperCase(s.charAt(0))){ // Checks if the first index is a Capital letter
            hasCap = true;}
        return hasCap;
    }

    /**
     * This method checks if there is an even amount of double quotation marks.
     * @param s -the input from the main function
     * @return true if there is an even amount, false if not.
     */
    public static boolean isEvenQuotes(String s) {
        boolean evenQuotes = false;
        int quoteCount = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '"') quoteCount++;
        }
        if(quoteCount %2 == 0){ // Modulus operator to check if there is an even omaount
            evenQuotes = true;
        }
        return evenQuotes;
    }

    /**
     *This method makes sure that the sentence has a terminating operator
     * @param s - Input from the user
     * @return true if it has one, false if not.
     */
    public static boolean hasTerminator(String s){
        boolean hasTermOp = false;
        if(s.endsWith("!")){
            hasTermOp = true;
        } else if ( s.endsWith(".")) {
            hasTermOp = true;
        } else if (s.endsWith("?")) {
            hasTermOp = true;
        }
        return hasTermOp;
    }

    /**
     * This method checks if there is more than one period in the sentence.
     * @param s - the input from the main function
     * @return true if there is only one period, false if multiple
     */
    public static boolean isOnePeriod(String s){
        boolean onePeriod = false;
        int periodCount = 0;
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(c == '.'){
                periodCount++;
            }
        }
        if(periodCount <= 1){ // If to check if there has been multiple periods counted.
            onePeriod = true;
        }
        return onePeriod;
    }

    /**
     * This checks if all the number beneath 13 are spelled out and not actual integers
     * @param s - the input from the main function
     * @return false if there is an int below 13, true if not
     */
    public static boolean isNoLowNum(String s) {
        String num;
        int i = 0;
        while(i <s.length()){
            char c = s.charAt(i);
            num = "";
            while(Character.isDigit(c)){
                num += c;
                i++;
                c = s.charAt(i);
            }
            if(!"".equals(num) && Integer.parseInt(num) < 13){ // Checks if num is not empty and
                return false;                                 // if so parse it into an int value and check if its below 13
            }
            num = "";
            i++;
        }
        return true;
    }
}
