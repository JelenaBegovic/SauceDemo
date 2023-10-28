package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage extends BaseTest {
    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "inventory_sidebar_link")
    public WebElement allItemsLink;

    public void clickOnAllItems() {
        allItemsLink.click();
    }

    @FindBy (id = "about_sidebar_link")
    public WebElement aboutLink;

    public void clickOnAbout() {
        aboutLink.click();
    }

    @FindBy (id = "logout_sidebar_link")
    public WebElement logoutLink;

    public void clickOnLogout() {
        logoutLink.click();
    }

    @FindBy (id = "reset_sidebar_link")
    public WebElement resetAppStateLink;

    public void clickOnResetAppState() {
        resetAppStateLink.click();
    }
}
