package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/");
    }

    @Test
    public void CheckoutProcessWithValidPersonalInformation () {
        loginPage.login(validUsername1);
        addProductToCart("Sauce Labs Onesie");
        addProductToCart("Sauce Labs Backpack");
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutYourInformationPage.inputFirstName("Petar");
        checkoutYourInformationPage.inputLastName("Petrovic");
        checkoutYourInformationPage.inputPostalCode("11000");
        checkoutYourInformationPage.clickOnContinueButton();
        Assert.assertTrue(checkoutOverviewPage.checkIfTheRightProductIsInTheCart("Sauce Labs Onesie"));
        Assert.assertTrue(checkoutOverviewPage.checkIfTheRightProductIsInTheCart("Sauce Labs Backpack"));
        Assert.assertTrue(checkoutOverviewPage.checkIfTheTotalSumIsEqualToTheDisplayedSum());
        checkoutOverviewPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-complete.html");
        Assert.assertTrue(checkoutFinishPage.confirmMessage.isDisplayed());
        Assert.assertEquals(checkoutFinishPage.getConfirmMessageText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @Test
    public void checkoutProcessWithAnEmptyCart() {
        loginPage.login(validUsername1);
        verifyThatTheCartIsEmpty();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");
    }

    @Test
    public void checkoutProcessWithInvalidPersonalInformation() {
        loginPage.login(validUsername1);
        addProductToCart("Sauce Labs Onesie");
        addProductToCart("Sauce Labs Backpack");
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutYourInformationPage.inputFirstName("123");
        checkoutYourInformationPage.inputLastName("657@");
        checkoutYourInformationPage.inputPostalCode("asdf");
        checkoutYourInformationPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-one.html");
    }

    @Test
    public void cancelCheckout() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutYourInformationPage.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");
        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());
    }

    @Test
    public void cancelTheCheckoutAtTheLastStep() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutYourInformationPage.inputFirstName("Petar");
        checkoutYourInformationPage.inputLastName("Petrovic");
        checkoutYourInformationPage.inputPostalCode("11000");
        checkoutYourInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

}
