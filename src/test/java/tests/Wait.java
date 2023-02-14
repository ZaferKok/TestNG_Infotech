package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.time.Duration;

public class Wait extends TestBase {

    /*
    Kullanıcı https://the-internet.herokuapp.com/dynamic_controls sayfasına gider.
    Kullanıcı Remove Butonuna tıklar.
    Kullanıcı "It's gone!" mesajını görür ve doğrular.

    Hard Wait = > Thread.sleep(1000); Her halükarda bekleme yapar

    Dinami Wait'ler:
    implicit Wait = > Driver'ın yolu üzerindeki elemanların ortaya çıkamı için dinamik bekleme yapar. Eğer element belirlenen süre içerisinde çıkmazsa hata verir.
    expilcitly Wait = > Driver özel olarak bir element'i bekelr. Çıkamazsa hata verir.
    Hem implicitly hem de explicitly wait element'in erken orataya çıkaması ile beklemeyi sonrlandırır.

     */


    @Test
    public void waitTest() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = Driver.getDriver().findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

        String expectedMessageText = "It's gone!";

        // Explicitly wait : Bir elemana özel bekleme yapar. TestBase'den Implicitly Wait i kapatıp deneyebilirsiniz.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20)); // Bekleme için önce obje oluşturuyoruz.
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))); // bu obje ile locate edeceğimiz elemanı özel bekliyoruz.

        // Implicitly wait : Bunu denemek için yukarıdaki wait objesini kapatın aşağıdaki satırları yorumdan çıkarıp implictily ile wait'in çalışmasını kontrol edebilirsiniz.
//      WebElement message2 = Driver.getDriver().findElement(By.id("message"));
//      String actualMessageText2 = message2.getText();

        String actualMessageText = message.getText();

        Assert.assertEquals(actualMessageText, expectedMessageText);

    }
}
