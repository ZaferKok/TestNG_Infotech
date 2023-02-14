package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadPage;
import utilities.Driver;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Download extends TestBase {

    DownloadPage downloadPage = new DownloadPage();

    @Test
    public void testDownload() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/download");
        downloadPage.downloadButton.click();
        Driver.wait(3);

        // Projenin bulunduğu klasörün path'i
        String mainFolder = System.getProperty("user.dir");
        System.out.println("mainFolder = " + mainFolder);

        // Kullanıcının home path'i'
        String userFolder = System.getProperty("user.home");
        System.out.println("userFolder = " + userFolder);

        String path = userFolder + "\\Downloads\\pexels-photo-323705.jpeg";
        boolean isFileExists = Files.exists(Paths.get(path));
        Assert.assertTrue(isFileExists);

    }
}
