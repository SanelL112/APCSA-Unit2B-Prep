package codecheck;

/**
 * CodeCheck #9: TrianglePrint
 *
 * Given a positive int, return a string containing a countdown triangle from
 * that number matching the examples. Each number is followed by a space,
 * including the last one on each line. No trailing newline after the last line.
 *
 * Example (n = 2):
 * "2 1 \n1 "
 */
public class TrianglePrint {
    public String triPrint(int n) {
        String result = "";
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                result += j + " ";
            }
            if(i > 1) {
                result += "\n";
            }
        }
        return result;
    }
}