package org.example.pages;

import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PA_05_HoverMainPage {

    public PA_05_HoverMainPage(){PageFactory.initElements(Hooks.driver,this);}
    public List<WebElement> ImageAvater() {return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));}
    public String CategoryTitle() {return Hooks.driver.findElement((By.cssSelector("div[class=\"page-title\"] h1"))).getText().toLowerCase().trim();}


    public void HO_1_HoverCategory() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        List<WebElement> mainCategories = ImageAvater() ;
        int count = mainCategories.size();
        System.out.println(count);
        int min = 0;
        int max = count - 1;
        int selectedCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        action.moveToElement(mainCategories.get(selectedCategory)).perform();
        String selectedMainCategoryName = mainCategories.get(selectedCategory).getText().toLowerCase().trim();

        String locator = "(//ul[@class='top-menu notmobile']//ul)[" +Integer.toString(selectedCategory+1)+"]/li";
        List<WebElement> subCategoryLocation = Hooks.driver.findElements(By.xpath(locator));

        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        if(!subCategoryLocation.isEmpty())
        {

            int SubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            subCategoryLocation.get(SubCategory).click();
            String SubCategoryName = subCategoryLocation.get(SubCategory).getText().toLowerCase().trim()   ;
            String subCategoryTitle = CategoryTitle();
            Assert.assertTrue(subCategoryTitle.contains(SubCategoryName.toLowerCase().trim()));            }
        else
        {
            mainCategories.get(selectedCategory).click();
            String ActualCategoryTitle = CategoryTitle();
            Assert.assertTrue(ActualCategoryTitle.contains(selectedMainCategoryName.toLowerCase().trim()));
        }

        Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

    }

}
