package com.fyz.chapter006.before;

public class ReplaceMethodWithObject {

    public static class Account {

        public int gamma(int inputVal, int quantity, int yearToDate) {
            int importantValue1 = (inputVal * quantity) + delta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100)
                importantValue2 -= 20;
            int importantValue3 = importantValue2 * 7;
            // and so on.
            return importantValue3 - 2 * importantValue1;
        }

        public int delta() {
            return 200;
        }
    }

    public static void main(String[] args) {
        Account r1 = new Account();

        System.out.println("r1: " + r1.gamma(100,100,100));
    }

}
