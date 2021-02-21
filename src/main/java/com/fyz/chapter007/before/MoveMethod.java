package com.fyz.chapter007.before;

public class MoveMethod {

    Account a = new Account(10);

    public class Account {

        public Account(int daysOverdrawn) {
            _type = new AccountType();
            _daysOverdrawn = daysOverdrawn;
        }

        double overdraftCharge() {
            if (_type.isPremium()) {
                double result = 10;
                if (_daysOverdrawn > 7) result += (_daysOverdrawn - 7) *
                        0.85;
                return result;
            } else return _daysOverdrawn * 1.75;
        }

        double bankCharge() {
            double result = 4.5;
            if (_daysOverdrawn > 0) result += overdraftCharge();
            return result;
        }

        private AccountType _type;
        private int _daysOverdrawn;
    }

    private class AccountType {
        public boolean isPremium() {
            return true;
        }
    }


    public static void main(String[] args) {
        MoveMethod m = new MoveMethod();
        System.out.println(m.a.bankCharge());

    }
}
