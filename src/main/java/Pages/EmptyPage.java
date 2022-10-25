package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmptyPage extends BasePage{
    public EmptyPage(WebDriver driver) {
        super(driver);
    }
    private By errorMsg = By.id("errorMsg");

    public String getErrorMsgToInvalidProducts ()
    {
        return getTextOfElement(errorMsg);
    }
}
