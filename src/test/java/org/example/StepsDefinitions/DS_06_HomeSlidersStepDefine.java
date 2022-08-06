package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_06_SliderMainPage;

public class DS_06_HomeSlidersStepDefine {

    PA_06_SliderMainPage Slider=new PA_06_SliderMainPage();


    @When ("user clicks on first slider")
    public void user_clicks_on_first_slider() throws InterruptedException {Slider.SLD_1_ClickFirstSliderPOM();}
    @And  ("user select product of first slider")
    public void user_select_product_first_slider() throws InterruptedException {Slider.SLD_2_SelectProductFirstSliderPOM();}
    @Then ("user go to first product page")
    public void user_go_to_first_product_page() throws InterruptedException {Slider.SLD_3_GoToFirstProuductPagePOM();}




    @When ("user clicks on second slider")
    public void user_clicks_on_second_slider() throws InterruptedException {Slider.SLD_4_ClickSecondSliderPOM();}
    @And  ("user select product of Second slider")
    public void user_select_product_second_slider() throws InterruptedException {Slider.SLD_5_SelectProductSecondSliderPOM();}
    @Then ("user go to second product page")
    public void user_go_to_second_product_page() throws InterruptedException {Slider.SLD_6_GoToSecondProuductPagePOM();}
}
