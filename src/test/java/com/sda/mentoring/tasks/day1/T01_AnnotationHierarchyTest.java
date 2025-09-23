package com.sda.mentoring.tasks.day1;

import org.testng.annotations.*;

public class T01_AnnotationHierarchyTest {

    /*
        AnnotationHierarchyTest
        Task 1: Basic TestNG Setup and Annotations
        Objective: Create a TestNG class demonstrating annotation hierarchy
        Requirements:
        Create a TestNG class called
        Implement all TestNG annotations (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod,
        @Test, @AfterMethod, @AfterClass, @AfterTest, @AfterSuite)
        Add print statements in each method to observe execution order
        Create 2 test methods
        Run the test and analyze console output
     */

    @BeforeSuite
    void beforeSuite(){
        System.out.println("Before Suite");
    }


    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }




    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class");
    }



    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }



    @Test
    void test01() {
        System.out.println("Test 01");
    }

    @Test
    void test02() {
        System.out.println("Test 02");
    }

    @AfterMethod
    void AfterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    void AfterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    void AfterSuite(){
        System.out.println("After Suite");
    }
}
