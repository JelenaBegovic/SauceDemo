package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage extends BaseTest {
    public CheckoutYourInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "first-name")
    public WebElement firstNameField;

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    @FindBy (id = "last-name")
    public WebElement lastNameField;

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    @FindBy (id = "postal-code")
    public WebElement postalCodeField;

    public void inputPostalCode(String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    @FindBy (css = ".btn_primary.cart_button")
    public WebElement continueButton;

    public void clickOnContinueButton() {
        continueButton.click();
    }

    @FindBy (css = ".cart_cancel_link.btn_secondary")
    public WebElement cancelButton;

    public void clickOnCancelButton() {
        cancelButton.click();
    }
}
