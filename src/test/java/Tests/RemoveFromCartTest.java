package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    int numberOfProductsInCart = 0;
    public void addProductToCart(String product) {
        homePage.clickOnProduct(product);
        itemPage.clickOnAddToCartButton();
        itemPage.clickOnBackButton();
        numberOfProductsInCart++;
    }
    @Test
    public void verifyRemovingTheDesiredProductsFromCart() {
        addProductToCart("Sauce Labs Onesie");
        addProductToCart("Sauce Labs Backpack");
        homePage.clickOnProduct("Sauce Labs Onesie");
        itemPage.clickOnRemoveButton();
        itemPage.clickOnBackButton();
        numberOfProductsInCart--;
        homePage.clickOnCart();
        Assert.assertEquals(cartPage.cartIcon.getText(), String.valueOf(numberOfProductsInCart));
        Assert.assertTrue(cartPage.checkingIfTheRightProductIsInTheCart("Sauce Labs Backpack"));
    }

    @Test
    public void verifyRemovingAllProductsFromCartFromItemPage() {
        homePage.addProductsToCart(3);
        homePage.removingAllProductsFromCart();
        verifyThatTheCartIsEmpty();
    }

    @Test
    public void verifyRemovingAllProductsFromCart() {
        homePage.clickOnCart();
        cartPage.removeAllProductsFromCart();
        verifyThatTheCartIsEmpty();
    }
}
