package com.fyz.chapter007.before;

public class MoveField {

    Account account = new Account(0.8);

    class Account {

        public Account(double _interestRate){
            _type = new AccountType();
            this._interestRate = _interestRate;
        }

        private AccountType _type;
        private double _interestRate;

        double interestForAmount_days(double amount, int days) {
            return _interestRate * amount * days / 365;
        }
    }

    class AccountType {
        public boolean isPremium() {
            return true;
        }
    }

    public static void main(String[] args) {
        MoveField m = new MoveField();
        System.out.println(m.account.interestForAmount_days(100,2));
    }

}
