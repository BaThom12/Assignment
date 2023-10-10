package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import org.openqa.selenium.WebDriver;

public class ProductPageObject extends BasePage {
    WebDriver driver;
    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnLoginLink(WebDriver driver, String locator){
        clickToElement(driver,locator);
    }
}
