package org.example.StepsDefinitions;

import io.cucumber.java.en.When;
import org.example.pages.PA_04_SearchMainPage;
import org.example.pages.PA_05_HoverMainPage;

public class DS_05_HoverCategoryStepDefine {
    PA_05_HoverMainPage Hover= new PA_05_HoverMainPage();
    @When ("user could hover categories and select sub Category")
    public void user_clicks_in_search_filed() throws InterruptedException {Hover.HO_1_HoverCategory();}
}
