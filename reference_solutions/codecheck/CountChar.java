package codecheck;

public class CountChar {
    public int countChar(String phrase, String letter) {
        phrase = phrase.toLowerCase();
        letter = letter.toLowerCase();
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(letter)) {
                count++;
            }
        }
        return count;
    }
}
