package com.fyz.chapter006.before;

public class InlineTemp {

    private int price;

    public InlineTemp(int price) {
        this.price = price;
    }

    public boolean showcase() {
        double basePrice = price;
        return (basePrice > 1000);
    }

    public static void main(String[] args) {
        InlineTemp i1 = new InlineTemp(1100);
        InlineTemp i2 = new InlineTemp(100);
        System.out.println("i1:" + i1.showcase());
        System.out.println("i2:" + i2.showcase());
    }
}
