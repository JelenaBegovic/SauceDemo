package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BaseTest {

    public ItemPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn_primary.btn_inventory")
    public WebElement addToCartButton;

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    @FindBy (className = "inventory_details_back_button")
    public WebElement backButton;

    public void clickOnBackButton() {
        backButton.click();
    }

    @FindBy (css = ".btn_secondary.btn_inventory")
    public WebElement removeButton;

    public void clickOnRemoveButton() {
        removeButton.click();
    }

}
