package codecheck;

/**
 * CodeCheck #7: Exclamations
 *
 * Given a string, return that same string with every character followed by an
 * exclamation mark.
 *
 * Examples:
 * - "pizza" -> "p!i!z!z!a!"
 * - "I am sleepy" -> "I! !a!m! !s!l!e!e!p!y!"
 */
public class Exclamations {
    public String exclamation(String s) {
        String result = "";
        if(s==null || s.equals("")) {
            return s;
        } else if (s.length()<2) {
            return s + "!";
        } else {
            for(int i=0;i<s.length()-1;i++){
               result += s.substring(i,i+1);
               result += "!";
            }
            result += s.substring(s.length() - 1,s.length()) + "!";
        }
        return result;
    }
}

