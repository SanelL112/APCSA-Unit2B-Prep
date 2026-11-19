package codecheck;

/**
 * CodeCheck #8: NumberDoubler
 *
 * Take an input (will not be 0) and count how many times you have to double it
 * before it reaches 100 (i.e., before it is > 99 or < -99).
 *
 * Examples:
 * - 50 -> 1
 * - -14 -> 3
 * - 123 -> 0
 */
public class NumberDoubler {
    public int doubleNum(int input) {
        int count = 0;
        while(input < 100 && input > -100){
            input *= 2;
            count++;
        }
        return count;
    }
}
