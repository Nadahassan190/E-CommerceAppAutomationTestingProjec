package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_04_SearchMainPage;

public class DS_04_SearchingStepDefine {
    PA_04_SearchMainPage search=new PA_04_SearchMainPage();

    @When ("user clicks in search filed")
    public void user_clicks_in_search_filed(){search.SE_1_SearchFieldPOM();}

    @And  ("^user Type product name as \"(.*)\"$")
    public void user_type_product_name(String prouduct) throws InterruptedException {search.SE_2_ProductNamePOM(prouduct);}

    @Then ("user find relevant products")
    public void user_find_relevant_products(){search.SE_3_FindProductNamePOM();}

    @And  ("^user Type product sku as \"(.*)\"$")
    public void user_Type_product_sku(String sku) throws InterruptedException {search.SE_4_ProductSKUPOM(sku);}

    @Then ("^\"(.*)\" shown in result page")
    public void user_can_find_sku_in_Results(String sku) throws InterruptedException {search.SE_5_FindProductSKUPOM(sku);}

}
