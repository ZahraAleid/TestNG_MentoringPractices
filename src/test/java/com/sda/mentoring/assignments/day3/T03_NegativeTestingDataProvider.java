package com.sda.mentoring.assignments.day3;

import com.sda.mentoring.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T03_NegativeTestingDataProvider extends TestBase {
     /*
     Go to https://claruswaysda.github.io/signIn.html
     Do negative test with all scenarios - All should FAIL and show validation messages
 */

    @Test(dataProvider = "Credentials")
    void negativeWithDataProvider(String username, String password) {

        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement userField = driver.findElement(By.id("username"));
        WebElement passField = driver.findElement(By.id("password"));

        userField.sendKeys(username);
        passField.sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        if (ExpectedConditions.alertIsPresent().apply(driver) != null) {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert: " + alert.getText());
            alert.accept();
        }

        else {
            String userValidation = userField.getAttribute("validationMessage");
            String passValidation = passField.getAttribute("validationMessage");

            if (!userValidation.isEmpty()) {
                System.out.println("Missing Username" + userValidation);
            } else if (!passValidation.isEmpty()) {
                System.out.println("Missing Password " + passValidation);
            } else {
                System.out.println("Logged in successfully ");
            }
        }}

    @DataProvider(name = "Credentials")
    public Object[][] negativeTestsProvider() {
        return new Object[][]{
                {"myName", "pass"},
                {"admin", "pass"},
                {"myName", "123"},
                {"admin", ""},
                {"", "123"},
                {"", ""}

        };

    }
}