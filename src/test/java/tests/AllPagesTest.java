package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class AllPagesTest extends TestBase {

    AllPages allPages = new AllPages();

    @Test
    public void dragAndDrop() throws InterruptedException {

        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Driver.getDriver().switchTo().frame("gdpr-consent-notice");
        allPages.dragAndDropPage.acceptAllCookiesButton.click();

        Driver.wait(2);

        actions.dragAndDrop(allPages.dragAndDropPage.sourceValue5000plus, allPages.dragAndDropPage.targetInDepitAmountRight).build().perform();

        Driver.wait(2);

        String expectedValue = "5000";
        String actualValue = allPages.dragAndDropPage.savedValueInTableDebitSide.getText();
        Assert.assertEquals(actualValue, expectedValue);

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String tableTitle = allPages.tableTestPage.table.getText();
        System.out.println("tableTitle = " + tableTitle);

        System.out.println("=======================================================================");

        String tableFirstRowSecondData = allPages.tableTestPage.tr.getText();
        System.out.println("tableFirstRowSecondData = " + tableFirstRowSecondData);

        List<WebElement> satir3 = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));

        for (WebElement satir : satir3) {
            System.out.println(satir.getText());
        }

        System.out.println("=======================================================================");
        WebElement dataEmail1 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4)));
        System.out.println("dataEmail1 = " + dataEmail1);
        WebElement dataEmail2 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,3,4)));
        System.out.println("dataEmail2 = " + dataEmail2);
        WebElement dataEmail3 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4,5)));
        System.out.println("dataEmail3 = " + dataEmail3);
    }
}
