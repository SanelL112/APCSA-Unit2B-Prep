package codecheck;

/**
 * CodeCheck #5: CountChar
 *
 * Given a string and a single letter, count how many times that letter appears
 * in the string (case-insensitive).
 *
 * Examples:
 * - ("Pizza party", "p") -> 2
 * - ("hip hip hooray", "a") -> 1
 * - ("carpark", "j") -> 0
 */
public class CountChar {
    public int countChar(String phrase, String letter) {
        int count = 0;
        int l = 0;
        while(count < phrase.length()){
            if(Character.toLowerCase(phrase.charAt(count)) == Character.toLowerCase(letter.charAt(0))){
                l++;
                count++;
            } else {
                count++;
            }
        }
        return l;
    }
}
