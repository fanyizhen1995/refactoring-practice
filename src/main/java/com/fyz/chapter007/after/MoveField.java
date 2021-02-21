package com.fyz.chapter007.after;

public class MoveField {

    Account account = new Account(0.8);

    class Account {

        public Account(double _interestRate){
            _type = new AccountType(_interestRate);
        }

        private AccountType _type;

        double interestForAmount_days(double amount, int days) {

            return _type.get_interestRate() * amount * days / 365;
        }


    }

    class AccountType {

        private double _interestRate;
        public AccountType(double _interestRate) {
            this._interestRate = _interestRate;
        }
        public double get_interestRate() {
            return _interestRate;
        }

        public void set_interestRate(double _interestRate) {
            this._interestRate = _interestRate;
        }

        public boolean isPremium() {
            return true;
        }
    }

    public static void main(String[] args) {
        MoveField m = new MoveField();
        System.out.println(m.account.interestForAmount_days(100,2));
    }

}
