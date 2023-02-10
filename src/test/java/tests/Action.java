package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import static utilities.Driver.driver;

public class Action extends TestBase {

    @Test
    public void rightClickTest() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement element = Driver.getDriver().findElement(By.id("hot-spot"));
        Driver.wait(1);
        actions.contextClick(element).perform();
        Driver.wait(1);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(1);

    }

    @Test
    public void keyUpDown() throws InterruptedException {

        Driver.getDriver().get("https://www.ebay.de/");

        Driver.wait(2);
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        actions.keyDown(searchBox, Keys.SHIFT).  // Burada SHIFT tuşuna basılı tutmak için keyDown kullanıyoruz.
                sendKeys("iphone x").            // Burada SHIFT tuşuna basılı iken iphone x yazısını küçük harf ile gönderiyoruz. Ancak searchBox içine büyük harf olarak giriş yapıyor driver.
                keyUp(searchBox, Keys.SHIFT).    // Burada SHIFT tuşuna basmayı bırakıyoruz.
                perform();
        Driver.wait(2);

    }

    @Test
    public void scrollUpDown() throws InterruptedException {

        Driver.getDriver().get("https://www.ebay.de/");

        Driver.wait(2);
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.END).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.HOME).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.END).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.HOME).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.DOWN).perform();
        Driver.wait(2);
    }

    @Test
    public void doubleClick() throws InterruptedException {

        Driver.getDriver().get("https://www.ebay.de/");

        Driver.wait(2);
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys("iphone");
        Driver.wait(2);
        actions.doubleClick(searchBox).perform();
        Driver.wait(2);

    }

    @Test
    public void howerover() throws InterruptedException {

        Driver.getDriver().get("https://www.amazon.com/");

        Driver.wait(2);
        WebElement accountMenu = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(accountMenu).perform();
        Driver.wait(2);
        WebElement accountLink = Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Account')])[2]"));
        accountLink.click();
        Driver.wait(2);

        WebElement accountHeading = Driver.getDriver().findElement(By.tagName("h1"));
        String actualAccountHeadingText = accountHeading.getText();
        String expectedAccountHeading = "Your Account";
        Driver.wait(2);
        Assert.assertEquals(actualAccountHeadingText, expectedAccountHeading);

    }
}
