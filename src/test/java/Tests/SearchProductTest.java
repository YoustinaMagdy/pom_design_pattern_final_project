package Tests;

import Pages.EmptyPage;
import Pages.NavigatingParPage;
import Pages.ProductsPage;
import Pages.SearchedProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  SearchProductTest extends BaseTests {
    NavigatingParPage navigatingParPage;
    ProductsPage productsPage;
    @BeforeMethod
            public void addProductInCart()
    {
        NavigatingParPage navigatingParPage = new NavigatingParPage(driver);
        productsPage = navigatingParPage.cliconProductBtn();
    }
    @Test(priority = 0)
    public void testSearchProduct()
    {

        SearchedProductsPage searchedProductsPage = productsPage.searchProductField("Blue Top");
        Assert.assertEquals(searchedProductsPage.getTextSearchedProducts(), "SEARCHED PRODUCTS");
    }




    @Test(priority = 1)
    public void testSearchProductAndPressEnter()
    {
        SearchedProductsPage searchedProductsPage = productsPage.searchProductFieldAndPressEnter("Dress");
        Assert.assertEquals(searchedProductsPage.getTextSearchedProducts(), "SEARCHED PRODUCTS");
    }



    @Test(priority = 2)
    public void testErrorMsg()
    {
      EmptyPage emptyPage = productsPage.searchInvalidProductField("car");
      Assert.assertEquals(emptyPage.getErrorMsgToInvalidProducts(), "There is no results related to this search keyword","There is no results related to this search keyword");
    }
}






