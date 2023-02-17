package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragAndDropPage {

    public DragAndDropPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Accept All']")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "(//li[@id='fourth'])[1]")
    public WebElement sourceValue5000plus;

    @FindBy(xpath = "(//li[@class='placeholder'])[2]")
    public WebElement targetInDepitAmountRight;

    @FindBy (id = "t7")
    public WebElement savedValueInTableDebitSide;

}
