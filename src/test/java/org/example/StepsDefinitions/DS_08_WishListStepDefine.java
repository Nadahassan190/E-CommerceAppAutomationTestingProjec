package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_07_FollowMainPage;
import org.example.pages.PA_08_WishListMainPage;

public class DS_08_WishListStepDefine {
    PA_08_WishListMainPage Wish= new PA_08_WishListMainPage();

    @When ("user add product to wishlist")
    public void user_add_product_to_wishlist() throws InterruptedException {Wish.WL_1_AddProductPOM();}

    @Then ("wishlist notification success is visible")
    public void wishlist_notification_success_is_visible() throws InterruptedException {Wish.WL_2_NotificationSuccessPOM();}

    @When ("user add product to wishlist again")
    public void user_add_product_to_wishlist_again() throws InterruptedException {Wish.WL_3_AddMoreProductPOM();}

    @And  ("user go to wishlist page")
    public void user_go_to_wishlist_page() throws InterruptedException {Wish.WL_4_WishListPagePOM();}

    @Then ("number of quantity is greater than zero in wishlist page")
    public void quantity_is_greater_than_zero() throws InterruptedException {Wish.WL_5_QuantityMoreOnePOM();}





}
