package com.fyz.chapter006.after;

public class RemoveAssignmentsToParameters {

    int discount (int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if (inputVal > 50) result -= 2;
        if (quantity > 100) result -= 1;
        if (yearToDate > 10000) result -= 4;
        return result;
    }

    public static void main(String[] args) {
        RemoveAssignmentsToParameters r1 = new RemoveAssignmentsToParameters();
        System.out.println("r1: " + r1.discount(100, 10,10));
    }

}
