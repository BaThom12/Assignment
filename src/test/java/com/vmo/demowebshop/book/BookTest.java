package com.vmo.demowebshop.book;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.common.GlobalConstants;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.ProductPageUI;
import com.vmo.demowebshop.pageobject.LoginPageObject;
import com.vmo.demowebshop.pageobject.BookPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BookTest extends BaseTest {
    private static WebDriver driver;
    private LoginPageObject login;
    private BookPageObject book;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(GlobalConstants.DEMOWEBSHOP_URL);
        Log.info("Open Demo shop");
        login = new LoginPageObject(driver);
        book = new BookPageObject(driver);
    }

    @Test
    public void Product_TC01_Buy2BooksHighestRated() throws InterruptedException{
        verifyEquals(login.getTitlePage(driver), "Demo Web Shop");
        book.clickOnLoginLink(driver, ProductPageUI.LOCATOR_BOOK_TAG);
        verifyEquals(book.getTitleBookPage(driver),"Demo Web Shop. Products tagged with 'book'");
        String namebook = book.click2ItemHasRatingHighest(driver,ProductPageUI.LOCATOR_RATING);
        verifyEquals(book.getMessageAddToCartSuccess(driver,ProductPageUI.LOCATOR_MESSAGE_ADD_CART_SUCCESS),"The product has been added to your shopping cart");
        Thread.sleep(3000);
        verifyEquals(book.getQuantify(driver,ProductPageUI.LOCATOR_CART_QUANTITY),"(2)");
        book.hoverOnShoppingCartTag(driver,ProductPageUI.LOCATOR_SHOPPING_CART_TAG);
        verifyEquals(namebook,book.getBookName(driver,ProductPageUI.LOCATOR_BOOK_NAME));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
