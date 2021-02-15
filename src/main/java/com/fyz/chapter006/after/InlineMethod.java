package com.fyz.chapter006.after;

public class InlineMethod {

    private int _numberOfLateDeliveries;

    public InlineMethod(int numberOfLateDeliveries){
        this._numberOfLateDeliveries = numberOfLateDeliveries;
    }

    int getRating() {
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }



    public static void main(String[] args) {
        InlineMethod i1 = new InlineMethod(6);
        InlineMethod i2 = new InlineMethod(4);
        System.out.println("i1:" + i1.getRating());
        System.out.println("i2:" + i2.getRating());
    }

}
