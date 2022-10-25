package Tests;

import Pages.CartPage;
import Pages.NavigatingParPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddToCartTest extends BaseTests {
    NavigatingParPage navigatingParPag;
    CartPage cartPag;
    @BeforeMethod
    public void addProductInCart ()
    {
         navigatingParPag = new NavigatingParPage(driver);
        ProductsPage productsPage = navigatingParPag.cliconProductBtn();
        productsPage.addFirstProductToCart();
        cartPag = productsPage.clickViewCartButton();
    }




    @Test (priority = 0)
    public void testAddToCartFunctionality()
    {
        Assert.assertEquals(cartPag.getSizeOfAddedProducts(), 1, "The quantity of product should be 1  ");
    }



    @Test (priority = 1)
    public void testCheakColmnsHeader()
    {

        Assert.assertEquals(cartPag.getNumberOfHeader(), 6, "The Number Should Be 6");
        List<String> headers = new ArrayList<>();
        headers.add("Item");
        headers.add("Description");
        headers.add("Price");
        headers.add("Quantity");
        headers.add("Total");
        headers.add("Remove");
        Assert.assertTrue(cartPag.getHeadersText(headers), "the headers should be " + headers);

    }
}
