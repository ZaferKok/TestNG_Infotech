package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Iframe extends TestBase {

    /*
    WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframe']"));
    driver.switchTo().frame(iframe);    => konumlandırılmış iframe in web elementi eklenerek geçiş yapılır.
    driver.switchTo().frame(0);         => index numarası ile geçiş yapılır.
    driver.switchTo().frame("id");      => id ile geçiş yapılır.

    driver.switchTo().parentFrame();    => iç içe iframelerden herhangi birinde driver gezinirken bir üst iframe'e çıkmak için kullanılır.
    driver.switchTo().defaultContent(); => Bütün iframelerden çıkarak ana sayfaya dönüş yapar.
     */

    @Test
    public void iframeTest() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        Driver.getDriver().switchTo().frame("mce_0_ifr");

        String expectedMessage = "Elemental Selenium";

        WebElement textDoc = Driver.getDriver().findElement(By.id("tinymce"));
        Driver.wait(1);
        textDoc.clear();
        Driver.wait(1);
        textDoc.sendKeys("Iframe test training");
        actions.doubleClick(textDoc).perform();
        Driver.wait(1);
        Driver.getDriver().switchTo().parentFrame();
        WebElement boldButton = Driver.getDriver().findElement(By.xpath("//button[@title='Bold']"));
        boldButton.click();
        Driver.wait(1);
        WebElement message = Driver.getDriver().findElement(By.xpath("(//a[@target='_blank'])[2]"));
        String actualMessage = message.getText();

        // Validating the message
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
