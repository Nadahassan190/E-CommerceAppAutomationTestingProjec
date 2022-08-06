package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_02_LoginPage;

public class DS_02_LoginStepDefine {

    PA_02_LoginPage login =new PA_02_LoginPage();

    @Given("user go to login page")
    public void user_go_to_login_page(){login.LO_1_loginLinkPOM();}

    @When("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void user_login_with_valid() throws InterruptedException {login.LO_2_EnterValidEmailPOM("testtry1@example.com","P@ssw0rd");}

    @When("user login with \"invalid\" \"Wrongtest@example.com\" and \"WrongP@ssw0rd\"")
    public void user_login_with_Invalid(){login.LO_5_EnterInValidEmailPOM("Wrongtest@example.com","WrongP@ssw0rd");}

    @And("user press on login button")
    public void user_login_button() throws InterruptedException {login.LO_3_loginBttnPOM();}

    @Then("user login to the system successfully")
    public void user_login_successfully(){login.LO_4_SuccessfullLoginPOM();}

    @Then("user could not login to the system")
    public void user_login_Unsuccessfully(){login.LO_6_UnSuccessfullLoginPOM();}

}
