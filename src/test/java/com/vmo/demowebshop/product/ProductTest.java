package com.vmo.demowebshop.product;

import com.vmo.demowebshop.common.GlobalConstants;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {
    private static WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(GlobalConstants.DEMOWEBSHOP_URL);
        Log.info("Open Demo shop");
    }
    @Test
    public void  Login_TC01_GetDataFromExcel(){

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
