package com.fyz.chapter007.after;

public class MoveMethod {

    Account a = new Account(10);

    public class Account {

        public Account(int daysOverdrawn) {
            _type = new AccountType();
            _daysOverdrawn = daysOverdrawn;
        }

        double overdraftCharge(){
            return _type.overdraftCharge(_daysOverdrawn);
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

        double overdraftCharge(int daysOverdrawn ) {
            if (isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7) result += (daysOverdrawn - 7) *
                        0.85;
                return result;
            } else return daysOverdrawn * 1.75;
        }
    }


    public static void main(String[] args) {
        MoveMethod m = new MoveMethod();
        System.out.println(m.a.bankCharge());

    }
}
