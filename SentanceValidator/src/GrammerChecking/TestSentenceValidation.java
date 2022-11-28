package GrammerChecking;

/**
 This class tests the SentenceValidation class in this package
 The rules for the validity of a sentence are:
 •	String starts with a capital letter.
 •	String has an even number of quotation marks.
 •	String ends with one of the following sentence termination characters: ".", "?", "!"
 •	String has no period characters other than the last character.
 •	Numbers below 13 are spelled out (” one”, “two”, "three”, etc…).

 @author Evan McCullough
 @version 1.0
 */


public class TestSentenceValidation {
    public static void main(String [] args){
        //Valid strings to test
        String validStr1 = "The quick brown fox said “hello Mr lazy dog”.";
        String validStr2 = "The quick brown fox said hello Mr lazy dog.";
        String validStr3 = "One lazy dog is too few, 13 is too many.";
        String validStr4 = "One lazy dog is too few, thirteen is too many.";
        String validStr5 = "How many \"lazy dogs\" are there?";

        //Invalid strings to test
        String invalidStr1 = "The quick brown fox said \"hello Mr. lazy dog\".";
        String invalidStr2 = "the quick brown fox said “hello Mr lazy dog\".";
        String invalidStr3 = "\"The quick brown fox said “hello Mr lazy dog.\"";
        String invalidStr4 = "One lazy dog is too few, 12 is too many.";
        String invalidStr5 = "Are there 11, 12, or 13 lazy dogs?";
        String invalidStr6 = "There is no punctuation in this sentence";

        // Valid Sentence tests
        System.out.println("++++++++Valid Sentence tests+++++++++++++");
        System.out.println(testValidation(validStr1));
        System.out.println(testValidation(validStr2));
        System.out.println(testValidation(validStr3));
        System.out.println(testValidation(validStr4));
        System.out.println(testValidation(validStr5));
        System.out.println("+++++++END OF VALID TESTING++++++++++++++");
        System.out.println();

        System.out.println("++++++++Invalid Sentence tests+++++++++++++");
        System.out.println(testValidation(invalidStr1));
        System.out.println(testValidation(invalidStr2));
        System.out.println(testValidation(invalidStr3));
        System.out.println(testValidation(invalidStr4));
        System.out.println(testValidation(invalidStr5));
        System.out.println(testValidation(invalidStr6));
        System.out.println("+++++++END OF INVALID TESTING++++++++++++++");
    }

    /**
     * Method that use the isSentence method from the SentenceValidation class
     * @param s - Input from the main function
     * @return - A string that says whether the sentence is valid or not
     */
    public static String testValidation(String s){
        SentenceValidation sv = new SentenceValidation();
        ;
        if(sv.isSentence(s)){
            return "This isa valid sentence.";
        }
        return "This is an invalid sentence." ;
    }


}
