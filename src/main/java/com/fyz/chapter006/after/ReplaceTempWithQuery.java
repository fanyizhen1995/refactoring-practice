package com.fyz.chapter006.after;

public class ReplaceTempWithQuery {

    private int _quantity;

    private int _itemPrice;

    public ReplaceTempWithQuery(int _quantity, int _itemPrice) {
        this._quantity = _quantity;
        this._itemPrice = _itemPrice;
    }

    double getPrice() {

        return basePrice() * discountFactor();
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }

    private double discountFactor() {
        if (basePrice() > 1000) return  0.95;
        else return  0.98;
    }

    public static void main(String[] args) {
        ReplaceTempWithQuery r1 = new ReplaceTempWithQuery(10, 100);
        System.out.println("r1: " + r1.getPrice());
    }

}
