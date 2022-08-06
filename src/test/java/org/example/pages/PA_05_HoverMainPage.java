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
        SoftAssert soft = new SoftAssert();
        Actions action = new Actions(Hooks.driver);
        List<WebElement> mainCategories = ImageAvater();
        int count = mainCategories.size();
        int min = 0;
        int max = count - 1;
        int SelectedCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);

        action.moveToElement(mainCategories.get(SelectedCategory)).perform();
        String selectedMainCategoryName = mainCategories.get(SelectedCategory).getText().toLowerCase().trim();
        System.out.println(count);
        System.out.println(selectedMainCategoryName);
        String location = "(//ul[@class='top-menu notmobile']//ul)[" +Integer.toString(SelectedCategory+1)+"]/li";
        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(location));
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if(!subCategoryLinks.isEmpty()) {

                int subCount = subCategoryLinks.size();
                System.out.println(subCount);
                System.out.println(subCategoryLinks.get(0).getText());
                System.out.println(subCategoryLinks.get(1).getText());
                System.out.println(subCategoryLinks.get(2).getText());

                int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
                String selectedSubCategoryName = subCategoryLinks.get(selectedSubCategory).getText();
                subCategoryLinks.get(selectedSubCategory).click();

                String subCategoryTitle = CategoryTitle();
                System.out.println(subCategoryTitle);
                System.out.println(selectedSubCategoryName);
                soft.assertTrue(subCategoryTitle.contains(selectedSubCategoryName.toLowerCase().trim()));}

        else {
            mainCategories.get(SelectedCategory).click();
            String CategoryTitle =CategoryTitle();
            soft.assertTrue(CategoryTitle.contains(selectedMainCategoryName.toLowerCase().trim()));
            Hooks.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            soft.assertAll();
            }
    }

}
