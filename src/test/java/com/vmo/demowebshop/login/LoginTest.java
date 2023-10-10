package com.vmo.demowebshop.login;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.common.GlobalConstants;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.helper.TestNGListener;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import com.vmo.demowebshop.pageobject.LoginPageObject;
import com.vmo.demowebshop.utils.ExcelConfig;
import com.vmo.demowebshop.utils.ExcelUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Epic("Demowebshop")
@Feature("Login")
@Story("Login by excel data")
@Listeners(TestNGListener.class)
public class LoginTest extends BaseTest {
    private static WebDriver driver;
    private LoginPageObject login;


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(GlobalConstants.DEMOWEBSHOP_URL);
        Log.info("Open Demo shop");
        login = new LoginPageObject(driver);
    }

    @Test(dataProvider = "getInforLogin", dataProviderClass = ExcelConfig.class)
    public void Login_TC01_GetDataFromExcel(String STT, String username, String password, String expect) throws StackOverflowError {
        verifyTrue(login.getTitlePage(driver).contains("Demo Web Shop"));
        login.clickOnLoginLink(driver, LoginPageUI.LOCATOR_LOGIN_TAG);
        verifyEquals(login.getTitlePage(driver), "Demo Web Shop. Login");
        login.enterValueOnTextBox(driver, LoginPageUI.LOCATOR_EMAIL_TEXTBOX, username);
        login.enterValueOnTextBox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, password);
        login.clickOnLoginLink(driver, LoginPageUI.LOCATOR_LOGIN_BUTTON);
       verifyEquals(login.getTextError(driver,STT,LoginPageUI.LOCATOR_MESSAGE,LoginPageUI.LOCATOR_MESSAGE_VALIDATE_ERROR),expect);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
