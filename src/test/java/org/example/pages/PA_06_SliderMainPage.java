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

import java.util.concurrent.TimeUnit;

public class PA_06_SliderMainPage {

    public PA_06_SliderMainPage(){PageFactory.initElements(Hooks.driver,this);}
    public WebElement FirstSliderPOM() {return Hooks.driver.findElement(By.cssSelector("a[href=\"/computers\"]"));}
    public WebElement FirstSliderProductElemertPOM() {return Hooks.driver.findElement(By.cssSelector("img[alt=\"Picture for category Notebooks\"]"));}
    public WebElement FirstProductPOM() {return Hooks.driver.findElement(By.cssSelector("a[href=\"/hp-spectre-xt-pro-ultrabook\"]"));}
    public WebElement FirstproudxctnamePOM() {return Hooks.driver.findElement(By.className("product-name"));}



    public WebElement SecondSliderPOM() {return Hooks.driver.findElement(By.cssSelector("a[href=\"/books\"]"));}
    public WebElement SecondSliderProductElemertPOM() {return Hooks.driver.findElement(By.cssSelector("img[alt=\"Picture of Fahrenheit 451 by Ray Bradbury\"]"));}
    public WebElement SeconfdproudxctnamePOM() {return Hooks.driver.findElement(By.className("product-name"));}




    public void SLD_1_ClickFirstSliderPOM() throws InterruptedException {FirstSliderPOM().click();Thread.sleep(1000);}
    public void SLD_2_SelectProductFirstSliderPOM() throws InterruptedException {FirstSliderProductElemertPOM().click();Thread.sleep(1000);FirstProductPOM().click();}
    public void SLD_3_GoToFirstProuductPagePOM() throws InterruptedException {

        Thread.sleep(1000);
        SoftAssert soft = new SoftAssert();

        String ActualPageURL = Hooks.driver.getCurrentUrl();
        String ExpectedPageURL = "https://demo.nopcommerce.com/hp-spectre-xt-pro-ultrabook";
        soft.assertEquals(ActualPageURL, ExpectedPageURL);

        String actualResultMsg = FirstproudxctnamePOM().getText();
        String expectedResultMsg = "HP Spectre XT Pro UltraBook";
        System.out.println(actualResultMsg);
        soft.assertTrue(actualResultMsg.contains(expectedResultMsg));


        soft.assertAll();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    public void SLD_4_ClickSecondSliderPOM() throws InterruptedException {SecondSliderPOM().click();Thread.sleep(1000);}
    public void SLD_5_SelectProductSecondSliderPOM() throws InterruptedException {SecondSliderProductElemertPOM().click();Thread.sleep(1000);}
    public void SLD_6_GoToSecondProuductPagePOM() throws InterruptedException {
        Thread.sleep(1000);
        SoftAssert soft = new SoftAssert();
        String SecondSliderProductUrl = Hooks.driver.getCurrentUrl();
        String expectedPage = "https://demo.nopcommerce.com/fahrenheit-451-by-ray-bradbury";
        System.out.println(SecondSliderProductUrl);
        Assert.assertEquals(SecondSliderProductUrl, expectedPage);

        String actualResultMsg = SeconfdproudxctnamePOM().getText();
        String expectedResultMsg = "Fahrenheit 451 by Ray Bradbury";
        System.out.println(actualResultMsg);
        soft.assertTrue(actualResultMsg.contains(expectedResultMsg));

        soft.assertAll();
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }



}
