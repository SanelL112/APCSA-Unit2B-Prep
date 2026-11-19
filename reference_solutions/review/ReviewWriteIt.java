package review;

public class ReviewWriteIt {

    public static int countOddDigits(int num) {
        int count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 1) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static String reverseWord(String word) {
        String rev = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            rev += word.substring(i, i + 1);
        }
        return rev;
    }

    public static boolean hasVowelPair(String word) {
        boolean hasVowelPair = false;
        for (int i = 0; i < word.length() - 1; i++) {
            String curr = word.substring(i, i + 1);
            String next = word.substring(i + 1, i + 2);
            if ("aeiou".indexOf(curr) >= 0 && "aeiou".indexOf(next) >= 0) {
                hasVowelPair = true;
            }
        }
        return hasVowelPair;
    }
}
