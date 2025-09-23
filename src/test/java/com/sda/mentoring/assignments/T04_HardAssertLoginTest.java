package com.sda.mentoring.assignments;

import com.sda.mentoring.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T04_HardAssertLoginTest extends TestBase {
    /*
    Test Case: Positive Login Test
        1. Navigate to https://claruswaysda.github.io/signIn.html
        2. Enter username: "admin"
        3. Enter password: "123"
        4. Click Submit button
        5. Use hard assertions to verify:
        New page URL is "https://claruswaysda.github.io/signIn.html"
        Page contains text "Employee Table"

    Implementation Requirements:
        Create class HardAssertLoginTest
        Use appropriate WebDriver setup and teardown
        Implement proper element locators
        Use meaningful assertion messages

     */

    @Test
    void hardAssertion(){

        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement usernameLocator = driver.findElement(By.id("username"));
        WebElement passwordLocator = driver.findElement(By.id("password"));
        WebElement submitLocator = driver.findElement(By.xpath("//input[@type='submit']"));
        WebElement headerText = driver.findElement(By.xpath("//h1[@id='employeeHeader']"));

        usernameLocator.sendKeys("admin");
        passwordLocator.sendKeys("123");
        submitLocator.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://claruswaysda.github.io/signIn.html","The current URL doesn't match with the expected URL");

        Assert.assertEquals(headerText.getText(),"Employee Table", "The page contain the expected text 'Employee Table' ");

    }
}
