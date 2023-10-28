package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    //For sorting by NAME(A to Z) input "az"      For sorting by PRICE(low to high) input "lohi"
    //                   (Z to A) input "za"                          (high to low) input "hilo"
    @Test
    public void verifySortingProductsFromAToZ() {
        homePage.sortingProducts("az");
        Assert.assertTrue(homePage.sortedProductsByNameAtoZ());
    }

    @Test
    public void verifySortingProductsFromZToA() {
        homePage.sortingProducts("za");
        Assert.assertTrue(homePage.sortedProductsByNameZtoA());
    }

    @Test
    public void verifySortingProductsFromLowToHigh() {
        homePage.sortingProducts("lohi");
        Assert.assertTrue(homePage.sortedProductsByPriceLowToHigh());
    }

    @Test
    public void verifySortingProductsFromHighToLow() {
        homePage.sortingProducts("hilo");
        Assert.assertTrue(homePage.sortedProductsByPriceHighToLow());
    }


}
