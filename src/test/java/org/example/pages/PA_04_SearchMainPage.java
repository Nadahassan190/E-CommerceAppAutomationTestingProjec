package org.example.pages;

import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PA_04_SearchMainPage {

    public PA_04_SearchMainPage(){PageFactory.initElements(Hooks.driver,this);}
    public WebElement SearchFieldPOM() {return Hooks.driver.findElement(By.id("small-searchterms"));}
    public WebElement SearchButtonPOM() {return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));}
    public WebElement SearchSKUAsserPOM() {return Hooks.driver.findElement(By.className("picture"));}
    public WebElement ActualProductSKUPOM() {return Hooks.driver.findElement(By.className("sku"));}
    public List<WebElement> ExpectedItemName() {return Hooks.driver.findElements(By.className("product-item"));}
    public List<WebElement> ActualSearchItem() {return Hooks.driver.findElements(By.id("small-searchterms"));}

    public void SE_1_SearchFieldPOM(){SearchFieldPOM().click();SearchFieldPOM().clear();}
    public void SE_2_ProductNamePOM(String Product) throws InterruptedException {
        SearchFieldPOM() .sendKeys(Product);
        SearchButtonPOM().click();
        Thread.sleep(2000);
    }
    public void SE_3_FindProductNamePOM()  {
        int item = Hooks.driver.findElements(By.id("small-searchterms")).size();
        for (int x = 0; x<item; x++)
        {
            String ExpectedItemName = ExpectedItemName().get(x).getText();
            String ActualSearchItem = ActualSearchItem() .get(x).getText();
            Assert.assertTrue(ExpectedItemName.contains(ActualSearchItem));
        }
    }
    public void SE_4_ProductSKUPOM(String skuProduct) throws InterruptedException {
        SearchFieldPOM() .sendKeys(skuProduct);
        SearchButtonPOM().click();
        Thread.sleep(2000);
    }
    public void SE_5_FindProductSKUPOM(String sku) throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        int item = Hooks.driver.findElements(By.id("small-searchterms")).size();
        for (int x = 0; x<item; x++) {
            String ExpectedItemName = ExpectedItemName().get(x).getText();
            String ActualSearchItem = ActualSearchItem() .get(x).getText();
            soft.assertTrue(ExpectedItemName.contains(ActualSearchItem));
        }
            SearchSKUAsserPOM().click();
            Thread.sleep(2000);
            String ActualProductSKU =ActualProductSKUPOM().getText();
            System.out.println(ActualProductSKU);
            System.out.println(sku);
            String ExpectedProudctSKU = "SKU: ";
            soft.assertEquals(ExpectedProudctSKU.concat(sku),ActualProductSKU);
            soft.assertAll();

        }



}
