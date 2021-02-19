package com.fyz.chapter006.after;

public class ReplaceMethodWithObject {

    public static class Account {

        public int gamma(int inputVal, int quantity, int yearToDate) {
            return new Gamma(this, inputVal, quantity, yearToDate).compute();
        }

        public int delta() {
            return 200;
        }
    }

    public static class Gamma {
        private final Account _account;
        private int inputVal;
        private int quantity;
        private int yearToDate;
        private int importantValue1;
        private int importantValue2;
        private int importantValue3;

        public Gamma(Account account, int inputVal, int quantity, int yearToDate) {
            this._account = account;
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }

        int compute() {
            importantValue1 = (inputVal * quantity) + _account.delta();
            importantValue2 = (inputVal * yearToDate) + 100;
            importantThing();
            importantValue3 = importantValue2 * 7;
            // and so on.
            return importantValue3 - 2 * importantValue1;
        }

        void importantThing() {
            if ((yearToDate - importantValue1) > 100)
                importantValue2 -= 20;
        }
    }

    public static void main(String[] args) {
        Account r1 = new Account();

        System.out.println("r1: " + r1.gamma(100,100,100));
    }

}
