package com.fyz.chapter001.after;

abstract public class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}






