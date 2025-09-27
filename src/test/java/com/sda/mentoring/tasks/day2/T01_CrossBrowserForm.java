package com.sda.mentoring.tasks.day2;

import com.sda.mentoring.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class T01_CrossBrowserForm extends TestBase {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill form and submit
    Do all actions and assert
    Do this test with Chrome, Edge and Firefox
*/


    @Test
    public void testName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://claruswaysda.github.io/ActionsForm.html");
        driver.findElement(By.id("name")).sendKeys("John doe");
        driver.findElement(By.id("age")).sendKeys("30");
        new Select(driver.findElement(By.id("options"))).selectByVisibleText("IT Department");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        Assert.assertTrue(alertText.contains("Your passcode is:"));


    }
}



