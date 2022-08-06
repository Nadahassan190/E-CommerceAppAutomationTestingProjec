package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_01_RegisterPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DS_01_RegistrationStepDefine {

    PA_01_RegisterPage register = new PA_01_RegisterPage();

    @Given ("user go to register page")
    public void user_go_to_registerPage(){register.AC_1_RegisterSteps();}

    @When  ("user select gender type")
    public void user_select_genderType(){register.AC_2_GenderPOM();}

    @And   ("user enter first name \"automation\" and last name \"tester\"")
    public void user_enter_firstName_LastName(){register.AC_3_NamePOM("automation","tester");}

    @And   ("user enter date of birth")
    public void user_enter_dateOf_Birth(){register.AC_4_BirthDateDayPOM();}

    @And    ("user enter email \"test@example.com\" field")
    public void user_enter_email(){register.AC_5_EmailAndCompanyPOM("testtry1@example.com","FWD");}

    @And   ("user fills Password fields \"P@ssw0rd\"")
    public void user_fills_Password_fields(){register.AC_6_EnterPasswordPOM("P@ssw0rd","P@ssw0rd");}

    @And    ("user clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {register.AC_7_registerButtnPOM();}

    @Then  ("success message is displayed")
    public void success_message_is_displayed(){register.AC_8_result();}


}
