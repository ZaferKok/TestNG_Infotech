package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadPage;
import utilities.Driver;
import utilities.TestBase;

public class Upload extends TestBase {

    /* Kullanıcı https://the-internet.herokuapp.com/upload sayfasına gider.
       Kullaınıcı Choose File'a path gönderir
       Kullanıcı Upload butonuna tıklar.
       Kullanıcı "File Uploaded!" mesajını görür ve doğrular.
     */

    UploadPage uploadPage = new UploadPage();

    @Test
    public void uploadTest() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/upload"); Driver.wait(2);
        String path = "C:\\Users\\zafer\\Downloads\\dog.jpeg"; //"C:/Users/zafer/Downloads/dog.jpeg"; bu şekilde de kullanılabilir.
        uploadPage.chooseFile.sendKeys(path); Driver.wait(1);
        uploadPage.uploadButton.click(); Driver.wait(1);
        boolean actualResult = uploadPage.successMessage.isDisplayed();
        Assert.assertTrue(actualResult);
    }
}
