package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "shopping_cart_container")
    public WebElement cartIcon;

    public void clickOnCart() {
        cartIcon.click();
    }

    @FindBy (className = "inventory_item_name")
    public List<WebElement> listOfProducts;

    public void clickOnProduct(String product) {
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getText().equalsIgnoreCase(product)) {
                listOfProducts.get(i).click();
                break;
            }
        }
    }

    @FindBy (css = ".btn_secondary.btn_inventory")
    public WebElement removeFromCartButton;

    @FindBy (className = "product_sort_container")
    public WebElement sortingButton;

    public void sortingProducts(String desiredSorting) {
        Select sorting = new Select(sortingButton);
        sorting.selectByValue(desiredSorting);
    }
//===========ASSERT SORT=================================================================================
    public boolean sortedProductsByNameAtoZ() {
        String[] listOfProductsNamesActual = new String[listOfProducts.size()];
        String[] listOfProductsNamesSorted = new String[listOfProducts.size()];
        for (int i = 0; i < listOfProducts.size(); i++) {
            listOfProductsNamesActual[i] = listOfProducts.get(i).getText();
            listOfProductsNamesSorted[i] = listOfProducts.get(i).getText();
        }
        Arrays.sort(listOfProductsNamesSorted);
        boolean sortedAToZ = true;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (!listOfProductsNamesActual[i].equalsIgnoreCase(listOfProductsNamesSorted[i])) {
                sortedAToZ = false;
                break;
            }
        }
        return sortedAToZ;
    }

    public boolean sortedProductsByNameZtoA() {
        String[] listOfProductsNamesActual = new String[listOfProducts.size()];
        String[] listOfProductsNamesSorted = new String[listOfProducts.size()];
        for (int i = 0; i < listOfProducts.size(); i++) {
            listOfProductsNamesActual[i] = listOfProducts.get(i).getText();
            listOfProductsNamesSorted[i] = listOfProducts.get(i).getText();
        }
        Arrays.sort(listOfProductsNamesSorted);
        boolean sortedZToA = true;
        for (int i = 0; i < listOfProducts.size(); i++) {
            int j = listOfProducts.size() - 1 - i;
            if (!listOfProductsNamesSorted[i].equalsIgnoreCase(listOfProductsNamesActual[j])){
                sortedZToA = false;
                break;
            }
        }
        return sortedZToA;
    }

    @FindBy (className = "inventory_item_price")
    public List<WebElement> listOfPrices;
    public boolean sortedProductsByPriceLowToHigh() {
        double[] listOfProductsPricesActual = new double[listOfPrices.size()];
        double[] listOfProductsPricesSorted = new double[listOfPrices.size()];
        for (int i = 0; i < listOfPrices.size(); i++) {
            listOfProductsPricesActual[i] = Double.parseDouble(listOfPrices.get(i).getText().substring(1));
            listOfProductsPricesSorted[i] = Double.parseDouble(listOfPrices.get(i).getText().substring(1));
        }
        Arrays.sort(listOfProductsPricesSorted);
        boolean sortedLowToHigh = true;
        for (int i = 0; i < listOfPrices.size(); i++) {
            if (listOfProductsPricesActual[i] != listOfProductsPricesSorted[i]) {
                sortedLowToHigh = false;
                break;
            }
        }
        return sortedLowToHigh;
    }

    public boolean sortedProductsByPriceHighToLow() {
        double[] listOfProductsPricesActual = new double[listOfPrices.size()];
        double[] listOfProductsPricesSorted = new double[listOfPrices.size()];
        for (int i = 0; i < listOfPrices.size(); i++) {
            listOfProductsPricesActual[i] = Double.parseDouble(listOfPrices.get(i).getText().substring(1));
            listOfProductsPricesSorted[i] = Double.parseDouble(listOfPrices.get(i).getText().substring(1));
        }
        Arrays.sort(listOfProductsPricesSorted);
        boolean sortedHighToLow = true;
        for (int i = 0; i < listOfPrices.size(); i++) {
            int j = listOfPrices.size() - 1 - i;
            if (listOfProductsPricesActual[i] != listOfProductsPricesSorted[j]) {
                sortedHighToLow = false;
                break;
            }
        }
        return sortedHighToLow;
    }
//====================================================================================================
//============SOCIAL NETWORK==========================================================================
    @FindBy (className = "social_twitter")
    public WebElement twitterIcon;

    @FindBy (className = "social_facebook")
    public WebElement facebookIcon;

    @FindBy (className = "social_linkedin")
    public WebElement linkedInIcon;

    public void clickOnTwitter() {
        twitterIcon.click();
    }
    public void clickOnFacebook() {
        facebookIcon.click();
    }
    public void clickOnLinkedIn() {
        linkedInIcon.click();
    }
//======================================================================================================

    @FindBy (css = ".btn_primary.btn_inventory")
    public List<WebElement> listOfAddToCartButtons;

    public String numberOfProductsInCart = "";
    public void addProductsToCart(int numberOfProducts) {
        if (numberOfProducts <= listOfAddToCartButtons.size()) {
            for (int i = numberOfProducts - 1; i >= 0 ; i--) {
                listOfAddToCartButtons.get(i).click();
            }
            numberOfProductsInCart = String.valueOf(numberOfProducts);
        } else {
            for (WebElement listOfAddToCartButton : listOfAddToCartButtons) {
                listOfAddToCartButton.click();
            }
            numberOfProductsInCart = String.valueOf(6);
            System.out.println("We're sorry, but currently we don't have the desired quantity of products");
        }
    }

    public void addRandomProductToCart() {
        Random random = new Random();
        int index = random.nextInt(listOfAddToCartButtons.size());
        listOfAddToCartButtons.get(index).click();
    }

    @FindBy (css = ".btn_secondary.btn_inventory")
    public List<WebElement> listOfRemoveButtons;

    public void removingAllProductsFromCart() {
        for (WebElement listOfRemoveButtons : listOfRemoveButtons) {
            listOfRemoveButtons.click();
        }
    }

    @FindBy (className = "bm-burger-button")
    public WebElement sidebarButton;

    public void clickOnSidebarButton() {
        sidebarButton.click();
    }

    @FindBy (className = "footer_copy")
    public WebElement termsOfServiceAndPrivacyPolicy;

    public void clickOnTermsOfServiceAndPrivacyPolicy() {
        termsOfServiceAndPrivacyPolicy.click();
    }
}
