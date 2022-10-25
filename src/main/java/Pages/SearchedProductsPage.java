package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedProductsPage extends BasePage {
    public SearchedProductsPage(WebDriver driver) {

        super(driver);
    }

    private By searchedProductsTxt = By.cssSelector(".title.text-center");
    private By searchProductsItem = By.cssSelector(".features_items");

    public String getTextSearchedProducts()
    {
    return getTextOfElement(searchedProductsTxt);

    }
}
