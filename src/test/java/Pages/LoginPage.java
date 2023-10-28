package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "user-name")
    public WebElement usernameField;

    public void inputUsername(String string) {
        usernameField.clear();
        usernameField.sendKeys(string);
    }

    @FindBy (id = "password")
    public WebElement passwordField;

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @FindBy (id = "login-button")
    public WebElement loginButton;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    @FindBy (xpath = "//*[@id=\"login_button_container\"]/div/form/h3")
    public WebElement errorMessage;

    public void login(String username) {
        inputUsername(username);
        inputPassword(validPassword);
        clickOnLoginButton();
    }
}

