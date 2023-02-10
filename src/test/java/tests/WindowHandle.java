package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

import static utilities.Driver.driver;

public class WindowHandle extends TestBase {

    @Test
    public void testWindowHandle() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.google.com', '_blank');");
        Driver.wait(2);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.amazon.com', '_blank');");
        Driver.wait(2);
        Set<String> handles = Driver.getDriver().getWindowHandles();
        Driver.getDriver().switchTo().window(handles.toArray()[0].toString());
        Driver.wait(2);

        for (int i = 0; i < handles.size(); i++) {

            Driver.getDriver().switchTo().window(handles.toArray()[i].toString());
            System.out.println(i + ". window ==> " + Driver.getDriver().getTitle());
            Driver.wait(1);

        }
    }
}
