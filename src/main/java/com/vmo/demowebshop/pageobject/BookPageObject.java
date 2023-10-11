package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookPageObject extends BasePage {
    WebDriver driver;

    public BookPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginLink(WebDriver driver, String locator) {
        Log.allure("Click on Login link");
        clickToElement(driver, locator);
    }

    public String getTitleBookPage(WebDriver driver) {
        Log.allure("Get title of Book page");
        return driver.getTitle();
    }

    private void sortArray(ArrayList<Integer> array) {
        Collections.sort(array, Collections.reverseOrder());
    }

    public String click2ItemHasRatingHighest(WebDriver driver, String locatorRating) throws InterruptedException {
        List<WebElement> arrWebElementRating = getListWebElements(driver, locatorRating);
        ArrayList<Integer> arrRating = new ArrayList<>();
        String strRating = "";
        int temp = 0;
        for (int i = 0; i < arrWebElementRating.size(); i++) {
            strRating = arrWebElementRating.get(i).getAttribute("style");
            temp = Integer.valueOf(strRating.substring(7, 9));
            arrRating.add(temp);
        }
        Collections.sort(arrRating, Collections.reverseOrder());
        String locatorTemp = "//div[@class='rating']//div[@style='width: numberRating%']/parent::div/parent::div/following-sibling::div[@class='add-info']//input[@value='Add to cart']";
        String locatorHighest1 = "";
        String locatorHighest2 = "";
        locatorHighest1 = locatorTemp.replace("numberRating", String.valueOf(arrRating.get(1)));
        locatorHighest2 = locatorTemp.replace("numberRating", String.valueOf(arrRating.get(2)));
        clickToElement(driver, locatorHighest1);
        Thread.sleep(3000);
        clickToElement(driver, locatorHighest2);
        Log.allure("Add success 2 book rating highest");
        String nameTemp = "//div[@class='rating']//div[@style='width: number%']/parent::div/parent::div/preceding-sibling::h2/a";
        String nameTemp1 = driver.findElement(By.xpath(nameTemp.replace("number", String.valueOf(arrRating.get(1))))).getText();
        String nameTemp2 = driver.findElement(By.xpath(nameTemp.replace("number", String.valueOf(arrRating.get(2))))).getText();
        String nameOfBook =  nameTemp1+ "-" + nameTemp2;
        return nameOfBook;
    }

    public String getMessageAddToCartSuccess(WebDriver driver, String locator) {
        Log.allure("Add to cart success");
        return getTextElement(driver, locator);
    }

    public String getQuantify(WebDriver driver, String locator) {
        Log.allure("Get quantity");
        return getTextElement(driver, locator);
    }

    public void hoverOnShoppingCartTag(WebDriver driver, String locator) {
        hoverMouseToElement(driver, locator);
        Log.allure("Hover success");
    }

    public String getBookName(WebDriver driver, String bookname) throws InterruptedException {
        List<WebElement> arrWebElementBookName = getListWebElements(driver, bookname);
        ArrayList<String> arrNameBook = new ArrayList<>();
        for (int i = 0; i < arrWebElementBookName.size(); i++) {
            arrNameBook.add(arrWebElementBookName.get(i).getText());
        }
        Collections.sort(arrNameBook);
        String name = arrNameBook.get(0) + "-" + arrNameBook.get(1);
        return name;
    }
}
