package codecheck;

public class TrianglePrint {
    public String triPrint(int n) {
        String result = "";
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                result += j + " ";
            }
            if (i > 1) {
                result += "\n";
            }
        }
        return result;
    }
}
