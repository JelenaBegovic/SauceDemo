package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkingToSocialNetworksTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void accessTheTwitterPageOfTheStore() {
        homePage.clickOnTwitter();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void accessTheFacebookPageOfTheStore() {
        homePage.clickOnFacebook();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void accessTheLinkedInPageOfTheStore() {
        homePage.clickOnLinkedIn();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
}
