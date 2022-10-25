package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    private By allProductsTxt = By.cssSelector(".title.text-center");
   private By searchProductPar = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By firstProduct = By.xpath("(//div[@class=\"productinfo text-center\"])[1]");
    private By addToCartBtnOfFirstProduct = By.xpath("(//div[@class=\"productinfo text-center\"]/a)[1]");

    private By secondProduct = By.xpath("(//div[@class=\"productinfo text-center\"])[2]");
    private By addToCartBtnOfSecondProduct = By.xpath("(//div[@class=\"productinfo text-center\"]/a)[2]");

    private By continueShoppingBtn = By.xpath("//button[contains(@class,'close-modal')]");
    private By viewCartBtn = By.xpath("//div[@class=\"modal-body\"]//a");






    public String getAllProductsTxt ()
    {
        return getTextOfElement(allProductsTxt);
    }

    public  SearchedProductsPage searchProductField( String product){
        typeOnInputField(searchProductPar , product);
        clickElement(searchBtn);
        return new  SearchedProductsPage(driver);
    }
    public  EmptyPage searchInvalidProductField( String product){
        typeOnInputField(searchProductPar , product);
        clickElement(searchBtn);
        return new EmptyPage(driver);
    }
    public  SearchedProductsPage searchProductFieldAndPressEnter( String product)
    {
        typeOnInputField(searchProductPar,product+ Keys.ENTER);
        return new  SearchedProductsPage(driver);
    }

    public  SearchedProductsPage searchProductPar( String product){
        typeOnInputField(searchProductPar , product);
        return new  SearchedProductsPage(driver);
    }

    public void addFirstProductToCart() {
        scrollVertically(700);
        hoverOverElement(firstProduct);
        forceClickOnElement(addToCartBtnOfFirstProduct);
    }
    public void addFirstProductToCartAgain() {
        scrollVertically(700);
        hoverOverElement(firstProduct);
        forceClickOnElement(addToCartBtnOfFirstProduct);
    }

    public void addSecondProductToCart() {
        hoverOverElement(secondProduct);
        forceClickOnElement(addToCartBtnOfSecondProduct);
    }

    public ProductsPage clickContinueShoppingBtn() {
        clickElement(continueShoppingBtn);
        return new ProductsPage(driver);
    }

    public CartPage clickViewCartButton() {
        clickElement(viewCartBtn);
        return new CartPage(driver);
    }

}

