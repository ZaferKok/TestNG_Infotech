package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TableTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {

    TableTestPage tableTestPage = new TableTestPage();

    @Test
    public void tableTest() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String tableTitle = tableTestPage.table.getText();
        System.out.println("tableTitle = " + tableTitle);

        System.out.println("=======================================================================");

        String tableFirstRowSecondData = tableTestPage.tr.getText();
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
    @Test
    public void tableTest_2() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        WebElement dataEmail1 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4)));
        System.out.println("dataEmail1 = " + dataEmail1);
    }

    @Test
    public void tableTest_3() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        WebElement dataEmail2 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,3,4)));
        System.out.println("dataEmail2 = " + dataEmail2);
    }
    @Test
    public void tableTest_4() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        WebElement dataEmail3 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4,5)));
        System.out.println("dataEmail3 = " + dataEmail3);
    }
}
