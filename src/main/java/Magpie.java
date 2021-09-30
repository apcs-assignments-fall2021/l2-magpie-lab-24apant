import java.util.Locale;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findWord(statement, "no") != -1)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement, "mother") != -1 || findWord(statement, "father") != -1 ||
                findWord(statement, "sister") != -1 || findWord(statement, "brother") != -1)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement, "dog") != -1 || findWord(statement, "cat") != -1){
            response = "Tell me more about your pets.";
        }
        else if (statement.contains("Nathan") || statement.contains("nathan")){
            response = "He sounds like a good teacher.";
        }
        else if (statement.trim().equals("")){
            response = "Please say something.";
        }

        else if (statement.contains("soccer") || statement.contains("basketball") || statement.contains("footbal") || statement.contains("volleyball")){
            response = "That sounds like a fun sport.";
        }
        else if (statement.contains("Ice cream") || statement.contains("ice cream")){
            response = "I looove Ice cream.";
        }
        else if (statement.contains("Spanish") || statement.contains("spanish")){
            response = "I am learning spanish right now.";
        }

        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4){
            response = "LOL, what a meme.";
        }

        else if (whichResponse == 5){
            response = "Sorry, I couldn't understand that.";
        }
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        String newStr = " " + str + " ";
        String firstLetter = word.substring(0, 1);

        if(newStr.contains(" " + word + " ")){
            return str.indexOf(word);
        }
        else if (newStr.contains(" " + firstLetter.toUpperCase() + word.substring(1))) {
            return str.indexOf(firstLetter.toUpperCase() + word.substring(1));
        }

        return -1;
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {

        //your code here
        return "Would you really be happy if you had" + statement.substring(6) + "?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        //your code here
        return "Why do you " + statement.substring(2, statement.indexOf("you")) + "me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return "What would it mean to" + statement.substring(9) + "?";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        String newStatement = statement.substring(statement.indexOf("you"));
        // your code here
        return "What makes you think that I " + newStatement.substring(4, newStatement.indexOf(" me")) + " you?";
    }
}
