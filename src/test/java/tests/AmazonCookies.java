package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

public class AmazonCookies extends TestBase {


    @Test
    public void testCookies() throws InterruptedException {

        Driver.getDriver().get("https://www.amazon.de/");
        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }

        Driver.wait(2);

        WebElement cookieButton = Driver.getDriver().findElement(By.id("sp-cc-accept"));
        //Driver.getDriver().manage().deleteAllCookies();
        cookieButton.click();
    }
}
