package org.example.StepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_03_CurranciesMainPage;

public class DS_03_CurranciesStepDefine {
    PA_03_CurranciesMainPage currancy= new PA_03_CurranciesMainPage();

    @When("user select euro currency")
    public void user_select_euro_currency() throws InterruptedException {currancy.CU_1_SelectCurrency();}
    @Then("user can find euro symbol displayed in home page products")
    public void user_can_find_euro_symbol(){currancy.CU_2_CurrencySymol();}
}
