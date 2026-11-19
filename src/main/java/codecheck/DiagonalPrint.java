package codecheck;

/**
 * CodeCheck #6: DiagonalPrint
 *
 * Given a positive integer (n), return a string containing an n by n grid of
 * asterisks except the positive diagonal (top left to lower right) is replaced
 * by an O. Each symbol is followed by a space, including the last one on each
 * line. No trailing newline after the last line.
 *
 * Example (n = 3):
 * "O * * \n* O * \n* * O "
 */
public class DiagonalPrint {
    public String diagonalPrint(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    result += "O ";
                } else {
                    result += "* ";
                }

            }
            if (i < n - 1) {
                result += "\n";
            }
        }
        return result;
    }
}
