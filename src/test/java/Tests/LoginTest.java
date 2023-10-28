package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/");
    }

    @Test
    public void UserCanLoginWithValidCredentials() {
        loginPage.login(validUsername1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
        Assert.assertTrue(homePage.cartIcon.isDisplayed());
    }

    @Test
    public void UserCannotLoginWithInvalidCredentials() {
        for (int i = 1; i <= excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 0);
            String invalidPassword = excelReader.getStringData("Login", i, 1);
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/");
        }
    }
}
