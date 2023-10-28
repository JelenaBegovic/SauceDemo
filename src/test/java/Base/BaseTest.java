package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public LoginPage loginPage;
    public HomePage homePage;
    public ItemPage itemPage;
    public CartPage cartPage;
    public SidebarPage sidebarPage;
    public CheckoutYourInformationPage checkoutYourInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutFinishPage checkoutFinishPage;


    public String validUsername1 = "standard_user";
    public String validUsername2 = "locked_out_user";
    public String validUsername3 = "problem_user";
    public String validUsername4 = "performance_glitch_user";
    public String validPassword = "secret_sauce";

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        excelReader = new ExcelReader("src/test/java/TestData.xlsx");
        loginPage = new LoginPage();
        homePage = new HomePage();
        itemPage = new ItemPage();
        cartPage = new CartPage();
        sidebarPage = new SidebarPage();
        checkoutYourInformationPage = new CheckoutYourInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutFinishPage = new CheckoutFinishPage();
    }

    public void verifyThatTheCartIsEmpty() {
        Assert.assertEquals(homePage.cartIcon.getText(), "");
    }
    public int numberOfProductsInCart = 0;
    public void addProductToCart(String product) {
        homePage.clickOnProduct(product);
        itemPage.clickOnAddToCartButton();
        itemPage.clickOnBackButton();
        numberOfProductsInCart++;
    }



}
