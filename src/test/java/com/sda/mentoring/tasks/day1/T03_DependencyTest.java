package com.sda.mentoring.tasks.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.fail;

public class T03_DependencyTest {
    /*
    Task 3: Dependency Testing
    Objective: Create interdependent test methods using dependsOnMethods
    Requirements:
    Create a class called DependencyTest
    Create a @BeforeClass method to set up WebDriver
    Create the following dependent test chain:
    openYahoo() - Navigate to Yahoo
    openBing() - Navigate to Bing (depends on Yahoo test)
    openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)
    Add intentional failure in Yahoo test and observe behavior
    Create @AfterClass method to close driver
     */

    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void openYahoo(){
        driver.get("https://www.yahoo.com");
      //  Assert.fail();
    }

    @Test(dependsOnMethods = "openYahoo")
    void openBing(){
        driver.get("https://www.bing.com");
    }

    @Test(dependsOnMethods = {"openBing", "openYahoo"})
    void openDuckDuckGo(){
        driver.get("https://duckduckgo.com/");
    }

    @AfterClass
    void tearDown(){
        driver.close();
        driver.quit();
    }
}

