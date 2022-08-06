package org.example.pages;

import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class PA_01_RegisterPage {

    public PA_01_RegisterPage(){PageFactory.initElements(Hooks.driver,this);}
    public WebElement RegisterLinkPOM() {return Hooks.driver.findElement(By.className("ico-register"));}
    public WebElement FirstNamePOM()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement LastNamePOM()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public WebElement GenderFemelePOM()
    {
        return Hooks.driver.findElement(By.id("gender-female"));
    }
    public WebElement EmailPOM(){return Hooks.driver.findElement(By.id("Email"));}
    public WebElement CompanyPOM()
    {
        return Hooks.driver.findElement(By.id("Company"));
    }
    public WebElement PasswordPOM()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement ConfirmPasswordPOM()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement registerBttnPOM()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }
    public WebElement BirthDateDayPOM()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement DateOfBirthMonthPOM()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement DateOfBirthYearPOM() {return Hooks.driver.findElement(By.name("DateOfBirthYear"));}
    public WebElement ActualResultTextPOM() {return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]"));}
    public WebElement ActualResultcolorPOM() {return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]"));}
    public WebElement logoutRegisterPOM() {return Hooks.driver.findElement(By.className("ico-logout"));}


    public void AC_1_RegisterSteps () {
        RegisterLinkPOM().click();
    }
        public void AC_2_GenderPOM(){
        GenderFemelePOM().click();
    }
    public void AC_3_NamePOM(String firstrname,String Lastname){
        FirstNamePOM().click();
        FirstNamePOM().clear();
        FirstNamePOM().sendKeys(firstrname);

        LastNamePOM().click();
        LastNamePOM().clear();
        LastNamePOM().sendKeys(Lastname);
    }

    public void AC_4_BirthDateDayPOM(){

        BirthDateDayPOM().click();
        Select select = new Select(BirthDateDayPOM());
        select.selectByValue("6");

        DateOfBirthMonthPOM().click();
        select = new Select(DateOfBirthMonthPOM());
        select.selectByValue("1");

        DateOfBirthYearPOM().click();
        select = new Select(DateOfBirthYearPOM());
        select.selectByValue("1998");
    }

    public void AC_5_EmailAndCompanyPOM(String email,String company){

        EmailPOM().click();
        EmailPOM().clear();
        EmailPOM().sendKeys(email);

        CompanyPOM().click();
        CompanyPOM().clear();
        CompanyPOM().sendKeys(company);
    }

    public void AC_6_EnterPasswordPOM(String password,String ConfirmPassword){

        PasswordPOM().click();
        PasswordPOM().clear();
        PasswordPOM().sendKeys(password);

        ConfirmPasswordPOM().click();
        ConfirmPasswordPOM().clear();
        ConfirmPasswordPOM().sendKeys(ConfirmPassword);
    }

    public void AC_7_registerButtnPOM() throws InterruptedException {registerBttnPOM().click();Thread.sleep(3000);}

    public void AC_8_result() {

        SoftAssert soft = new SoftAssert();

//        String expectedResult = "Your registration completed";
//        String actualResult = ActualResultcolorPOM().getText();
//        soft.assertTrue(actualResult.contains(expectedResult));
//        soft.assertEquals("https://demo.nopcommerce.com/registerresult/1", Hooks.driver.getCurrentUrl());

        String expectedResultt = "Your registration completed";
        String actualResultt =ActualResultTextPOM().getText();
        soft.assertEquals(actualResultt, expectedResultt);

        soft.assertAll();

    }

    public void AC_9_logoutSteps () {logoutRegisterPOM().click();}

}
