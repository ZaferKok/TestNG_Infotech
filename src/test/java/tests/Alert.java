package tests;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class Alert {

    @Test
    public void checkboxTest(){
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");


    }

}
