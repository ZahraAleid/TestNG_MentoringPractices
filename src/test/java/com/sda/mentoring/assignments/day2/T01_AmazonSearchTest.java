package com.sda.mentoring.assignments.day2;

import com.sda.mentoring.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T01_AmazonSearchTest extends TestBase {
    /*
    1. Navigate to: https://www.amazon.com
    2. Search for different keywords: Java, Selenium
    3. Assert that result text contains the searched word
    4. Run tests from XML file using parameters

     */

    @Test
    @Parameters("searchKeyword")
    public void amazonSearchSuite(String keyword) {
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(keyword),"Search results should contain: " + keyword);
    }


}
