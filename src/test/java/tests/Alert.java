package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Alert extends TestBase {

    @Test
    public void alertAccept() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);
        WebElement alertButton = Driver.getDriver().findElement(By.cssSelector("button[onclick='jsAlert()']"));
        alertButton.click();
        String expecteTextOfAlert = "I am a JS Alert";
        String actualTextOfAlert = Driver.getDriver().switchTo().alert().getText();
        System.out.println("actualTextOfAlert = " + actualTextOfAlert);
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        Assert.assertEquals(expecteTextOfAlert, actualTextOfAlert);

    }

    @Test
    public void alertAcceptAndDismiss() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);
        WebElement alertButton = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton.click();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        alertButton.click();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().dismiss();
        Driver.wait(2);

    }

    @Test
    public void sendMessageToAlert() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);
        WebElement alertButton = Driver.getDriver().findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        alertButton.click();
        Driver.wait(2);
        String expectedMessage = "Merhaba Alert";
        Driver.getDriver().switchTo().alert().sendKeys(expectedMessage);
        Driver.wait(2);
        //Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        WebElement message = Driver.getDriver().findElement(By.id("result"));
        Assert.assertTrue(message.getText().contains(expectedMessage));
        Driver.wait(2);
    }
}
