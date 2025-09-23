package com.sda.mentoring.assignments.day2;

import com.sda.mentoring.utilities.TestBase;
import org.testng.annotations.Test;

public class T02_GroupBasedTest extends TestBase {
    /*
    1. Create tests with groups: "smoke", "regression", "api"
    2. Create XML configurations to run specific groups
    3. Implement include/exclude group scenarios

     */


    @Test(groups = "smoke")
    void test01(){
        System.out.println("Test 01 - group smoke");
    }

    @Test(groups = {"smoke", "regression"})
    void test02(){
        System.out.println("Test 02 - group regression");
    }

    @Test(groups = "api")
    void test03(){
        System.out.println("Test 03 - group api");
    }

    @Test(groups = "smoke")
    void test04(){
        System.out.println("Test 04 - group smoke");
    }

    @Test(groups = "regression")
    void test05(){
        System.out.println("Test 05 - group regression");
    }

    @Test(groups = "api")
    void test06(){
        System.out.println("Test 06 - group api");
    }
}
