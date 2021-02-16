package com.fyz.chapter006.before;

public class ReplaceTempWithQuery {

    private int _quantity;

    private int _itemPrice;

    public ReplaceTempWithQuery(int _quantity, int _itemPrice) {
        this._quantity = _quantity;
        this._itemPrice = _itemPrice;
    }

    double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if (basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }

    public static void main(String[] args) {
        ReplaceTempWithQuery r1 = new ReplaceTempWithQuery(10, 100);
        System.out.println("r1: " + r1.getPrice());
    }

}
