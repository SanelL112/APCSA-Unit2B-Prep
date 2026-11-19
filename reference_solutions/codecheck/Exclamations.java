package codecheck;

public class Exclamations {
    public String exclamation(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            result += input.substring(i, i + 1) + "!";
        }
        return result;
    }
}
