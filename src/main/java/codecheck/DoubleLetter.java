package codecheck;

/**
 * CodeCheck #1: DoubleLetter
 *
 * Given a String (at least one character), determine whether it has the same
 * letter twice in a row. Return true if any letter is immediately followed by
 * the same letter, false otherwise. Capital and lowercase letters count as
 * different letters.
 *
 * Examples:
 * - "coffee" -> true
 * - "orange" -> false
 * - "x" -> false
 */
public class DoubleLetter {
    public boolean hasDoubleLetter(String word) {
        if(word.length()<2){
            return false;
        } else if(word.length() >= 2){
            for(int i=0;i<word.length()-1;i++){
                char testLetter = word.charAt(i);
                char nextLetter = word.charAt(i+1);
                if(nextLetter==testLetter){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
