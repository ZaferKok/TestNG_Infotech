package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

public class DragAndDrop extends TestBase {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    DragAndDropPage dragAndDropPage2 = new DragAndDropPage();
    DragAndDropPage dragAndDropPage3 = new DragAndDropPage();

    @Test
    public void dragAndDrop() throws InterruptedException {

        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Driver.getDriver().switchTo().frame("gdpr-consent-notice");
        dragAndDropPage.acceptAllCookiesButton.click();

        Driver.wait(2);

        actions.dragAndDrop(dragAndDropPage.sourceValue5000plus, dragAndDropPage.targetInDepitAmountRight).build().perform();

        Driver.wait(2);

        String expectedValue = "5000";
        String actualValue = dragAndDropPage.savedValueInTableDebitSide.getText();
        Assert.assertEquals(actualValue, expectedValue);

        // Drag and drop testi için aşağıdaki yöntem de kullanılabilir
        //actions.clickAndHold(element).moveToElement(element).release().build().perform();

    }
}
