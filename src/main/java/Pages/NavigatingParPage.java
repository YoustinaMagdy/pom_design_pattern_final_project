package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatingParPage extends BasePage{
    public NavigatingParPage(WebDriver driver) {
        super(driver);
    }
  private   By productBtn = By.xpath("//a[@href=\"/products\"]");


    public ProductsPage cliconProductBtn()
    {
        clickElement(productBtn);
        return new ProductsPage (driver) ;
    }
}
