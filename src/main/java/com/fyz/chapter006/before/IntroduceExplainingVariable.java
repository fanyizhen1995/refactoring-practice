package com.fyz.chapter006.before;

public class IntroduceExplainingVariable {

    private int _quantity;

    private int _itemPrice;

    public IntroduceExplainingVariable(int _quantity, int _itemPrice) {
        this._quantity = _quantity;
        this._itemPrice = _itemPrice;
    }

    double price() {
        // price is base price - quantity discount + shipping
        return _quantity * _itemPrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }

    public static void main(String[] args) {
        IntroduceExplainingVariable i1 = new IntroduceExplainingVariable(10, 100);
        System.out.println("i1: " + i1.price());
    }
}
