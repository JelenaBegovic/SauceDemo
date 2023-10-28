package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1");
    }


    @Test
    public void addTheDesiredProductsToCart() {
        loginPage.login(validUsername1);
        verifyThatTheCartIsEmpty();
        addProductToCart("Sauce Labs Onesie");
        addProductToCart("Sauce Labs Backpack");
        homePage.clickOnCart();
        Assert.assertEquals(cartPage.cartIcon.getText(), String.valueOf(numberOfProductsInCart));
        Assert.assertTrue(cartPage.checkingIfTheRightProductIsInTheCart("Sauce Labs Onesie"));
        Assert.assertTrue(cartPage.checkingIfTheRightProductIsInTheCart("Sauce Labs Backpack"));
    }


    @Test
    public void addTheDesireQuantityOfDifferentProducts() {
        loginPage.login(validUsername1);
        verifyThatTheCartIsEmpty();
        homePage.addProductsToCart(9);
        Assert.assertEquals(homePage.cartIcon.getText(), homePage.numberOfProductsInCart);
    }

    @Test
    public void addRandomProductToCart() {
        loginPage.login(validUsername1);
        verifyThatTheCartIsEmpty();
        homePage.addRandomProductToCart();
        Assert.assertEquals(homePage.cartIcon.getText(), "1");
    }

    @Test
    public void increaseQuantityOfProduct() {
        loginPage.login(validUsername1);
        verifyThatTheCartIsEmpty();
        addProductToCart("Sauce Labs Onesie");
        homePage.clickOnCart();
        cartPage.inputQuantity(3);
        Assert.assertEquals(homePage.cartIcon.getText(), String.valueOf(cartPage.productInCart));
    }


    @Test
    public void ContinueShoppingFunctionality() {
        loginPage.login(validUsername1);
        addProductToCart("Sauce Labs Onesie");
        addProductToCart("Sauce Labs Backpack");
        homePage.clickOnCart();
        cartPage.clickOnContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }


}
