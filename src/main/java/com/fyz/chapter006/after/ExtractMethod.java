package com.fyz.chapter006.after;

import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethod {

    private String _name;
    private Vector _orders = new Vector();

    public ExtractMethod(String name){
        this._name = name;
    }

    public void addOrder(Order order){
        _orders.addElement(order);
    }

    void printOwing() {
        double outstanding = getOutstanding();
        printBanner();
        printDetails(outstanding);
    }

    double getOutstanding() {
        Enumeration e = _orders.elements();
        double result = 0.0;
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    void printBanner() {
        System.out.println ("**************************");
        System.out.println ("***** Customer Owes ******");
        System.out.println ("**************************");
    }

    void printDetails(double outstanding) {
        System.out.println ("name:" + _name);
        System.out.println ("amount" + outstanding);
    }


    static class Order {
        private float amount;

        public Order(float amount) {
            this.amount = amount;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Order o1 = new Order(10);
        Order o2 = new Order(20);
        ExtractMethod e1 = new ExtractMethod("e1");
        e1.addOrder(o1);
        e1.addOrder(o2);
        e1.printOwing();
    }
}
