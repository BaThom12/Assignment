package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnLoginLink(WebDriver driver, String locator){
        clickToElement(driver,locator);
        Log.allure("Click on link");
    }
    public String getTitlePage(WebDriver driver){
        Log.allure("Get title of Page");
        return getTitle(driver);
    }

    public void enterValueOnTextBox(WebDriver driver, String locator, String value) {
        sendKeyToElement(driver,locator,value);
Log.allure("Enter value on textbox");
    }
    public String getTextError(WebDriver driver,String STT,String locator1, String locator2){
        int convertSTT = Integer.parseInt(STT);
        if(convertSTT <=4){
            return getTextElement(driver,locator1);
        }else if(convertSTT ==5){
            return getTextElement(driver,locator2);
        }else{
            return "";

        }

    }
}
