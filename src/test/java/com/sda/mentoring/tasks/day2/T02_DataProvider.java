package com.sda.mentoring.tasks.day2;

import com.sda.mentoring.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T02_DataProvider extends TestBase {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add records to the table using DataProvider
    Do it with all 3 ways

*/

    @DataProvider
    public Object[][] getRecords() {
        return new Object[][]{
                {"Tom", "34","UK"},
                {"Ken", "24","USA"},
                {"Michale", "28","Canada"},
                {"Jake", "36","UK"}
        };
    }


    @Test()
    void test(String name, String age, String country){
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

    }

}
