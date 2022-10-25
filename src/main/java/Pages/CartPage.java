package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver)
    {
        super(driver);
    }
   private By allCartRows = ByAll.xpath("//tr[contains(@id,'product-')]");
    private By firstProdcutPrice = By.xpath("//tr[@id=\"product-1\"]/td[@class=\"cart_price\"]") ;

    private By cartHeaders = By.cssSelector(".cart_menu >td");
    private By productQuantity = By.xpath("//button[@class='disabled']");
    private By productPriceTotal = By.className("cart_total_price");


    public int getSizeOfAddedProducts()
    {
      return locateListOfElement(allCartRows).size();
    }
    
    public String getFirstProductPrice ()
    {
        return getTextOfElement(firstProdcutPrice) ;
    }
    public String getQuantityofproduct()
    {
        return getTextOfElement(productQuantity);
    }
    public int getNumberOfHeader()
    {
        List<WebElement> headers = locateListOfElement(cartHeaders);
        return headers.size();
    }
    public boolean getHeadersText(List<String> expectedHeadersText) {
        List<WebElement> headers = locateListOfElement(cartHeaders);
        for (int i = 0; i < headers.size(); i++)
        {
            if (headers.get(i).getText() != expectedHeadersText.get(i))
            {
                return false;
            }
        }
        return true;
    }
    


    }


