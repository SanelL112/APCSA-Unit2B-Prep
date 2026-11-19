package codecheck;

public class DiagonalPrint {
    public String diagonalPrint(int n) {
        String result = "";
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) {
                    result += "O ";
                } else {
                    result += "* ";
                }
            }
            if (row < n - 1) {
                result += "\n";
            }
        }
        return result;
    }
}
