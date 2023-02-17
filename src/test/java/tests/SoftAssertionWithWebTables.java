package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TableTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class SoftAssertionWithWebTables extends TestBase {

    TableTestPage tableTestPage = new TableTestPage();

    @Test
    public void tableTest() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");

        WebElement dataEmail1 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4)));
        WebElement dataEmail2 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,3,4)));
        WebElement dataEmail3 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4,5)));

        String actualData1 = dataEmail1.getText();
        String actualData2 = dataEmail2.getText();
        String actualData3 = dataEmail3.getText();

        String expectedData1 = "$51.00";
        String expectedData2 = "$100.00";
        String expectedData3 = "http://www.timconway.com";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(dataEmail1.getText(),expectedData1, "Data1 hata verdi");
        softAssert.assertEquals(actualData2,expectedData2, "Data2 hata verdi");
        softAssert.assertEquals(actualData3,expectedData3, "Data3 hata verdi");

        softAssert.assertAll();

        /*
        Birden fazla Assert kullanmak ve bir failAssert sonucunda testimizin durmasını istemediğimizde SoftAssert kullanıyoruz.
        Böylece tüm assert işlemleri gerçekleştikten sonra hangi assertte hata varsa toplu olarak görebiliyoruz.
        Ancak testimizi yazarken softAssert.assertAll() işlemini kullanmazsak sonuçlar hatalı olsa bile Testimiz başarılıymış gibi görünür. Yani yalancı PASS alırız.
        Toplu bir sonuç değerlendirmesi için assertAll() zorunludur. Softassert lerden biri bile hatalı olsa o zaman testimiz fail olur.
        softAssert yaptığımız her validation için 3 değer girmemiz gerikiyor => actualData-expectedData ve hata durumunda alınacak mesaj.
         */
    }

}
