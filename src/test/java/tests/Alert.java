package tests;

import org.testng.annotations.Test;
import utilities.Driver;

public class Alert {
    
    @Test
    public void testCase1() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

    }
}
