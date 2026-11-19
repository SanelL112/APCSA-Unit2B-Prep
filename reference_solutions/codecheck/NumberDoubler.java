package codecheck;

public class NumberDoubler {
    public int doubleNum(int input) {
        int doubleNum = 0;
        while (input < 100 && input > -100) {
            input *= 2;
            doubleNum++;
        }
        return doubleNum;
    }
}
