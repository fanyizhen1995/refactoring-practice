package com.fyz.chapter001.after;

import org.junit.Test;

public class statementTest {

    @Test
    public void test(){
        System.out.println("Test After:");
        Movie mv1 = new Movie("movie a",0);
        Movie mv2 = new Movie("movie b",1);
        Movie mv3 = new Movie("movie c",2);
        Customer cs1 = new Customer("Customer a");
        Customer cs2 = new Customer("Customer b");
        Customer cs3 = new Customer("Customer c");
        Rental ra1 = new Rental(mv1, 2);
        Rental ra2 = new Rental(mv2, 4);
        Rental rb1 = new Rental(mv1, 1);
        Rental rb2 = new Rental(mv3, 6);
        Rental rc1 = new Rental(mv2, 4);
        Rental rc2 = new Rental(mv3, 1);
        cs1.addRental(ra1);
        cs1.addRental(ra2);
        cs2.addRental(rb1);
        cs2.addRental(rb2);
        cs3.addRental(rc1);
        cs3.addRental(rc2);

        System.out.println(cs1.statement());
        System.out.println(cs2.statement());
        System.out.println(cs3.statement());

    }

}
