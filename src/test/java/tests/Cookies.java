package tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Cookies extends TestBase {

       @Test
       public void testCookies() {

           Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");

           Driver.getDriver().manage().addCookie(new Cookie("_pbjs_userid_consent_data", "8316820400794021"));
           Driver.getDriver().manage().addCookie(new Cookie("gdpr-auditId", "dab7478b364c4568a923928589d6a610"));
           Driver.getDriver().navigate().refresh();

       }
}
