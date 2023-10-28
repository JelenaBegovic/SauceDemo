package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidebarTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void allItemsFromSidebar() {
        homePage.clickOnSidebarButton();
        sidebarPage.clickOnAllItems();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void aboutFromSidebar() {
        homePage.clickOnSidebarButton();
        sidebarPage.clickOnAbout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }

    @Test
    public void logoutFromSidebar() {
        homePage.clickOnSidebarButton();
        sidebarPage.clickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void resetAppStateFromSidebar() {
        homePage.clickOnSidebarButton();
        sidebarPage.clickOnResetAppState();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
        Assert.assertEquals(homePage.cartIcon.getText(), "");
    }
}
