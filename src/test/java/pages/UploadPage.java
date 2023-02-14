package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.TestBase;

public class UploadPage extends TestBase {

    public UploadPage() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (id = "file-upload")
    public WebElement chooseFile;

    @FindBy (id = "file-submit")
    public WebElement uploadButton;

    @FindBy (xpath = "//h3")
    public WebElement successMessage;

}
