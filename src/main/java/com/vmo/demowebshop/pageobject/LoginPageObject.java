package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnLoginLink(WebDriver driver, String locator){
        clickToElement(driver,locator);
    }
    public String getTitlePage(WebDriver driver){
        return getTitle(driver);
    }

    public void enterValueOnTextBox(WebDriver driver, String locator, String value) {
        sendKeyToElement(driver,locator,value);

    }
}
