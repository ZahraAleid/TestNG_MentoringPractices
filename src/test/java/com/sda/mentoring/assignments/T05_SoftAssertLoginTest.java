package com.sda.mentoring.assignments;

import com.sda.mentoring.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.SortedMap;

public class T05_SoftAssertLoginTest extends TestBase {

    /*
    Test Case: Negative Login Test
        1. Navigate to https://claruswaysda.github.io/signIn.html
        2. Enter username: "wronguser"
        3. Enter password: "wrongpass"
        4. Click Submit button
        5. Use soft assertions to verify:
        JavaScript alert is displayed
        Alert message text is "Incorrect username or password"

    Implementation Requirements:
        Create class SoftAssertLoginTest
        Handle JavaScript alert using WebDriver's Alert interface
        Use SoftAssert object for assertions
        Include proper assertAll() call
        Add meaningful assertion messages
     */

    @Test
    void softAssert(){
        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement usernameLocator = driver.findElement(By.id("username"));
        WebElement passwordLocator = driver.findElement(By.id("password"));
        WebElement submitLocator = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameLocator.sendKeys("wronguser");
        passwordLocator.sendKeys("wrongpass");
        submitLocator.click();

        SoftAssert softAssert = new SoftAssert();

        Alert alert = driver.switchTo().alert();

        softAssert.assertNotNull(alert , "Alert isn't showed ");
        softAssert.assertEquals(alert.getText(),"Incorrect username or password","Alert message isn't as expected");

        softAssert.assertAll();

    }
}
