package com.mb.learning;

import org.testng.annotations.*;

public class TestNGDemo {

    @Test(groups = {"smoke"})
    public void test1() {
        System.out.println("This is Test case 1");
    }


    @Test(groups = {"sanity"})
    public void test2() {
        System.out.println("This is Test case 2");
    }


    @Test(groups = {"regression"})
    public void test3() {
        System.out.println("This is Test case 3");
    }

    @Test(groups = {"smoke", "regression"})
    public void test4() {
        System.out.println("This is Test case 3");
    }
}