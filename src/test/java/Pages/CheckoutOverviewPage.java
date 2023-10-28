package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage extends BaseTest {
    public CheckoutOverviewPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "inventory_item_name")
    public List<WebElement> listOfProducts;

    public boolean checkIfTheRightProductIsInTheCart(String product) {
        boolean rightProductInTheCart = false;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getText().equalsIgnoreCase(product))
                rightProductInTheCart = true;
        }
        return rightProductInTheCart;
    }

    @FindBy (className = "inventory_item_price")
    public List<WebElement> listOfPrices;

    public double totalSumOfTheCart() {
        double sum = 0;
        for (WebElement price : listOfPrices) {
            sum += Double.parseDouble(price.getText().substring(1));
        }
        return sum;
    }

    @FindBy (className = "summary_subtotal_label")
    public WebElement totalSumDisplayed;

    public boolean checkIfTheTotalSumIsEqualToTheDisplayedSum() {
        return Double.parseDouble(totalSumDisplayed.getText().substring(13)) == totalSumOfTheCart();
    }

    @FindBy (css = ".btn_action.cart_button")
    public WebElement finishButton;

    public void clickOnFinishButton() {
        finishButton.click();
    }

    @FindBy (css = ".cart_cancel_link.btn_secondary")
    public WebElement cancelButton;

    public void clickOnCancelButton() {
        cancelButton.click();
    }
}
