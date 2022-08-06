package org.example.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PA_08_WishListMainPage {

    public PA_08_WishListMainPage(){PageFactory.initElements(Hooks.driver,this);}
    public WebElement AddProductPO() {return Hooks.driver.findElement(By.id("add-to-wishlist-button-7"));}
    public WebElement AddProductPO2() {return Hooks.driver.findElement(By.id("add-to-wishlist-button-12"));}
    public WebElement NotificationSuccessPO() {return Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));}
    public WebElement QuantityMoreOnePO() {return Hooks.driver.findElement(By.xpath("//input[@value=\"1\"]"));}
    public WebElement WishListPagePOM() {return  Hooks.driver.findElement(By.xpath("//a[@href=\"/wishlist\"]"));}
    public WebElement FirstSliderPOM() {return Hooks.driver.findElement(By.cssSelector("a[href=\"/computers\"]"));}
    public WebElement FirstSliderProductElemertPOM() {return Hooks.driver.findElement(By.cssSelector("img[alt=\"Picture for category Notebooks\"]"));}
    public WebElement FirstProductPOM() {return Hooks.driver.findElement(By.cssSelector("a[href=\"/hp-spectre-xt-pro-ultrabook\"]"));}
    public WebElement SecondSliderProductElemertPOM() {return Hooks.driver.findElement(By.cssSelector("img[alt=\"Picture for category Software\"]"));}
    public WebElement SecondProductPOM() {return Hooks.driver.findElement(By.cssSelector("img[alt=\"Picture of Sound Forge Pro 11 (recurring)\"]"));}
    public WebElement wishListProdsCheckPOM() {return Hooks.driver.findElement(By.cssSelector("td[class=\"product\"]"));}

    By wishListProdsCheckPOM = By.cssSelector("td[class=\"product\"]");
    public void WL_1_AddProductPOM() throws InterruptedException {
        FirstSliderPOM().click();Thread.sleep(1000);
        FirstSliderProductElemertPOM().click();Thread.sleep(1000);FirstProductPOM().click();
        Thread.sleep(1000);
        AddProductPO().getText();
        AddProductPO().click();
        Thread.sleep(3000);
        }
    public void WL_2_NotificationSuccessPOM(){
        SoftAssert soft = new SoftAssert();

        String ExpectedResult = "The product has been added to your wishlist";
        String ActualResult = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getText();
        soft.assertTrue(ActualResult.contains(ExpectedResult));

        WebElement successBar = NotificationSuccessPO();
        String ExpectedColor = successBar.getCssValue("background-color");
        String actualColor = Color.fromString(ExpectedColor).asHex();
        soft.assertTrue(successBar.isDisplayed(), "success notification bar is not displayed");
        soft.assertEquals(actualColor,"#4bb07a");

        soft.assertAll();
    }
    public void WL_3_AddMoreProductPOM() throws InterruptedException {
        WL_1_AddProductPOM();
        FirstSliderPOM().click();
        SecondSliderProductElemertPOM().click();SecondProductPOM().click();
        Thread.sleep(1000);
        AddProductPO2().click();
    }
    public void WL_4_WishListPagePOM(){WishListPagePOM().click();}
    public void WL_5_QuantityMoreOnePOM(){
        wishListProdsCheckPOM().click();
        int count = Hooks.driver.findElements(wishListProdsCheckPOM).size();
        Assert.assertTrue(count > 0);
    }
}
