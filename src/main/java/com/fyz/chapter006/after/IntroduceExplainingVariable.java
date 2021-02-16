package com.fyz.chapter006.after;

public class IntroduceExplainingVariable {

    private int _quantity;

    private int _itemPrice;

    public IntroduceExplainingVariable(int _quantity, int _itemPrice) {
        this._quantity = _quantity;
        this._itemPrice = _itemPrice;
    }

    double price() {
        // price is base price - quantity discount + shipping
        final double basePrice = _quantity * _itemPrice;
        final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;
    }

    // use Extract Method
    double price2() {
        // price is base price - quantity discount + shipping
        return basePrice() - quantityDiscount() + shipping();
    }

    private double basePrice() {
        return _quantity * _itemPrice;
    }

    private double quantityDiscount() {
        return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    }
    private double shipping() {
        return Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }


    public static void main(String[] args) {
        IntroduceExplainingVariable i1 = new IntroduceExplainingVariable(10, 100);
        System.out.println("i1-1: " + i1.price());
        System.out.println("i1-2: " + i1.price2());
    }
}
