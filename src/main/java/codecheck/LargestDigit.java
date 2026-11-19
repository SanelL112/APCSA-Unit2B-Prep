package codecheck;

/**
 * CodeCheck #2: LargestDigit
 *
 * Given a positive int, return its largest digit.
 *
 * Examples:
 * - 52819 -> 9
 * - 3020 -> 3
 * - 6 -> 6
 */
public class LargestDigit {
    public int largestDigit(int num) {
        int max = 0;
        int temp = 0;
        while(num > 0){
            temp = num % 10;
            if (temp > max) {
                max = temp;
            }
            num = num / 10;
        }
        return max;
    }
}
