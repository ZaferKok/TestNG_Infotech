package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class only once");
    }

    //create a method name:setUp() and use@BeforeMethod annotation
    @BeforeMethod
    public void beforeMethod() {
        //@BeforeMethod runs before each Method that has @Test annotation
        System.out.println("This is Before Method");
    }

   // @Ignore
    @Test (priority = 3)
    public void test1() {
        //@Test is used to create test cases or test method.
        //@Test annotation helps us run the test
        System.out.println("This is test 1 method");
    }

    @Test (priority = 1)
    public void test2() {
        System.out.println("This is test 2 method");
    }

    //How do you skip test3
    //Answer: We use @Ignore annotation to skip certain test cases.
   // @Ignore
    @Test (priority = 2, dependsOnMethods = "test2") // dependsOnMethods belirtilen metod çalışmadan bu testin devreye girmesini engeller.
    public void test3() {
        System.out.println("This is test 3 method");
    }

    @AfterMethod
    public void afterMethod() {
        //This will run after every @Test annotation
        System.out.println("This is after method");
    }

    @AfterClass
    public void afterClass() {
        //This will run after the whole class is done only once
        System.out.println("This is after class runs only once");
    }
}
