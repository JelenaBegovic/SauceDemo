package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinishPage extends BaseTest {
    public CheckoutFinishPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "complete-text")
    public WebElement confirmMessage;

    public String getConfirmMessageText() {
        return confirmMessage.getText();
    }
}
