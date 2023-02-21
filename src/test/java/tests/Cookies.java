package tests;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {

    AllPages allPages = new AllPages();

   @Test
   public void testCookies() throws InterruptedException {

       // Karşımıza Cookies onay butonları çıktığında aşağıdaki gibi butonları locate edip geçebiliriz.
//       Ama ayını zamanda aşağıdaki diğer yöntemler ile de Cookie leri handle edebiliriz.
//       Sayfada bu Cookie leri direk atlama imkanımız da bu şekilde olabilir.
//       Bunun için developer dan gerekli cookie bilgilerini almanız gerekebilir.

//           Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
//           Driver.getDriver().switchTo().frame("gdpr-consent-notice");
//           allPages.dragAndDropPage.acceptAllCookiesButton.click();
//           Driver.wait(2);

//           Driver.getDriver().get("https://www.google.com/");
//           Driver.wait(2);
//           WebElement rejectButton = Driver.getDriver().findElement(By.id("W0wltc"));
//           rejectButton.click();
//           Driver.wait(2);

       Driver.getDriver().get("https://www.google.com/");
       Driver.wait(2);
       WebElement acceptButton = Driver.getDriver().findElement(By.id("L2AGLb"));
       acceptButton.click();

       Set<Cookie> cookies = Driver.getDriver().manage().getCookies();

       System.out.println("Mevcut Cookie sayısı : " + cookies.size());

       for (Cookie cookie : cookies) {
           System.out.println(cookie.getName() + " ::::::::::: " + cookie.getValue());
       }

       System.out.println(Driver.getDriver().manage().getCookieNamed("SOCS"));

       System.out.println("=================================================================================");

   }
   @Test
   public void addCookiesTest() throws InterruptedException {

       Driver.getDriver().get("https://www.google.com/");
       Driver.wait(2);
       WebElement acceptButton = Driver.getDriver().findElement(By.id("L2AGLb"));
       acceptButton.click();

       Cookie cook = new Cookie("INFOTECH321", "123_infotech_321");
       Driver.getDriver().manage().addCookie(cook);

       Set<Cookie> cookies2 = Driver.getDriver().manage().getCookies();
       Driver.wait(1);
       for (Cookie cookie : cookies2) {
           System.out.println(cookie.getName() + " ::::::::::: " + cookie.getValue());
       }
       System.out.println("=================================================================================");
       System.out.println("Kendi oluşturduğumuz Cookie: " + Driver.getDriver().manage().getCookieNamed("INFOTECH321"));
       System.out.println("Mevcut Cookie sayısı in Cookies2 : " + cookies2.size());
       Driver.wait(1);

       System.out.println("=================================================================================");
       System.out.println("Oluşturduğumuz Cookie'yi silelim! ");
       Driver.getDriver().manage().deleteCookie(cook);
       Set<Cookie> cookies3 = Driver.getDriver().manage().getCookies();
       System.out.println("Kendi oluşturuduğumuz Cookie'yi Sildikten sonraki Mevcut Cookie sayısı in Cookies2 : " + cookies3.size());
       Driver.wait(1);

       System.out.println("=================================================================================");
       Driver.getDriver().manage().deleteAllCookies();
       Set<Cookie> cookies4 = Driver.getDriver().manage().getCookies();
       System.out.println("Tüm Cookie'leri Sildikten sonraki Mevcut Cookie sayısı in Cookies2 : " + cookies4.size());
   }

    @Test
    public void simulateLogin() throws InterruptedException {

       Driver.getDriver().get("http://www.memotome.com/home.asp?display=reminder");
       Driver.getDriver().manage().addCookie(new Cookie("DisplayInfo1", "PADI=842919&DateFormat=%25A%2C+%25B+%25%23d%2C+%25Y&DisplayName=Testing+Selenium"));
       Driver.getDriver().manage().addCookie(new Cookie("UserInfo1", "UserId=45LCWNBH"));

       Driver.wait(2);
       Driver.getDriver().get("http://www.memotome.com/home.asp?display=reminder");
       WebElement testRemeinder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'TEST REMINDER')]")));
       Assert.assertTrue(testRemeinder.isDisplayed());
   }

   @Test
   public void setConsentCookieTest() throws InterruptedException {

        Driver.getDriver().get("https://www.consentmanager.net/");
        Driver.wait(10);
        Driver.getDriver().manage().addCookie(new Cookie("__cmpcccu1", "aBPcfWCkgAwAzADUAIAC4FlgAA"));
        Driver.getDriver().manage().addCookie(new Cookie("__cmpconsent1", "BPcfWCkPcfWCkAfESDENDXAAAAAAAA"));
        Driver.getDriver().manage().addCookie(new Cookie("__uu", "MzIV5ys4BAe@5E-vzzzzzzzz"));
        Driver.getDriver().navigate().refresh();
   }
    @Test
    public void deleteCookieTest() throws InterruptedException {

        Driver.getDriver().get("https://www.consentmanager.net/");
        Driver.wait(10);
        Driver.getDriver().manage().addCookie(new Cookie("__cmpcccu1", "aBPcfWCkgAwAzADUAIAC4FlgAA"));
        Driver.getDriver().manage().addCookie(new Cookie("__cmpconsent1", "BPcfWCkPcfWCkAfESDENDXAAAAAAAA"));
        Driver.getDriver().manage().addCookie(new Cookie("__uu", "MzIV5ys4BAe@5E-vzzzzzzzz"));
        Driver.getDriver().navigate().refresh();
    }
}
