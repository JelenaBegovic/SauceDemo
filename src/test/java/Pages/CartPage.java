package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {
    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "shopping_cart_container")
    public WebElement cartIcon;

    @FindBy (className = "inventory_item_name")
    public List<WebElement> listOfProductsInTheCart;

    public boolean checkingIfTheRightProductIsInTheCart(String product) {
        boolean rightProductInTheCart = false;
        for (int i = 0; i < listOfProductsInTheCart.size(); i++) {
            if (listOfProductsInTheCart.get(i).getText().equalsIgnoreCase(product))
                rightProductInTheCart = true;
        }
        return rightProductInTheCart;
    }

    @FindBy (css = ".btn_secondary.cart_button")
    public List<WebElement> listOfRemoveButtons;

    public void removeAllProductsFromCart() {
        if (!listOfRemoveButtons.isEmpty()) {
            for (WebElement element : listOfRemoveButtons) {
                element.click();
            }
        } else
            System.out.println("Your cart is empty!");
    }

    @FindBy (xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]")
    public WebElement continueShoppingButton;

    public void clickOnContinueShopping() {
        continueShoppingButton.click();
    }

    @FindBy (css = ".btn_action.checkout_button")
    public WebElement checkoutButton;

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }


    @FindBy (className = "cart_quantity")
    public WebElement cartQuantityField;

    public int productInCart = 0;
    public void inputQuantity(int quantity) {
        cartQuantityField.clear();
        cartQuantityField.sendKeys(String.valueOf(quantity));
        productInCart = quantity;
    }

}
