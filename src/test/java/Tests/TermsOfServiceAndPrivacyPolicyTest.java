package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TermsOfServiceAndPrivacyPolicyTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/");
    }


    @Test
    public void termsOfServiceAndPrivacyPolicy() {
        loginPage.login(validUsername1);
        homePage.clickOnTermsOfServiceAndPrivacyPolicy();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
        Assert.assertFalse(homePage.termsOfServiceAndPrivacyPolicy.isDisplayed());
    }
}
