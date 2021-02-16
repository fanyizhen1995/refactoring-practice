package com.fyz.chapter006.before;

public class RemoveAssignmentsToParameters {

    int discount (int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) inputVal -= 2;
        if (quantity > 100) inputVal -= 1;
        if (yearToDate > 10000) inputVal -= 4;
        return inputVal;
    }

    public static void main(String[] args) {
        RemoveAssignmentsToParameters r1 = new RemoveAssignmentsToParameters();
        System.out.println("r1: " + r1.discount(100, 10,10));
    }

}
