package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PresenceOfElementsTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/");
    }

    @Test
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
    }

    @Test
    public void passwordFieldIsDisplayed() {
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }

    @Test
    public void loginButtonIsDisplayed() {
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void itemIsDisplayed() {
        loginPage.login(validUsername1);
        Assert.assertTrue(homePage.listOfProducts.get(0).isDisplayed());
    }

    @Test
    public void cartIconIsDisplayed() {
        loginPage.login(validUsername1);
        Assert.assertTrue(homePage.cartIcon.isDisplayed());
    }

    @Test
    public void logoutButtonIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.clickOnSidebarButton();
        Assert.assertTrue(sidebarPage.logoutLink.isDisplayed());
    }

    @Test
    public void dropDownMenuIsDisplayed() {
        loginPage.login(validUsername1);
        Assert.assertTrue(homePage.sortingButton.isDisplayed());
    }

    @Test
    public void checkoutButtonIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.clickOnCart();
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
    }

    @Test
    public void continueShoppingButtonIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.clickOnCart();
        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());
    }

    @Test
    public void firstNameFieldIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.firstNameField.isDisplayed());
    }

    @Test
    public void lastNameFieldIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.lastNameField.isDisplayed());
    }

    @Test
    public void postalCodeFieldIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.postalCodeField.isDisplayed());
    }

    @Test
    public void continueButtonIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.continueButton.isDisplayed());
    }

    @Test
    public void cancelButtonIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.cancelButton.isDisplayed());
    }

    @Test
    public void finishButtonIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutYourInformationPage.inputFirstName("Petar");
        checkoutYourInformationPage.inputLastName("Petrovic");
        checkoutYourInformationPage.inputPostalCode("11000");
        checkoutYourInformationPage.clickOnContinueButton();
        Assert.assertTrue(checkoutOverviewPage.finishButton.isDisplayed());
    }

    @Test
    public void cancelButtonAtLastStepIsDisplayed() {
        loginPage.login(validUsername1);
        homePage.addRandomProductToCart();
        homePage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutYourInformationPage.inputFirstName("Petar");
        checkoutYourInformationPage.inputLastName("Petrovic");
        checkoutYourInformationPage.inputPostalCode("11000");
        checkoutYourInformationPage.clickOnContinueButton();
        Assert.assertTrue(checkoutOverviewPage.cancelButton.isDisplayed());
    }

    
}
