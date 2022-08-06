package org.example.pages;

import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PA_02_LoginPage {

    public PA_02_LoginPage(){PageFactory.initElements(Hooks.driver,this);}
    public WebElement loginLinkPOM() {return Hooks.driver.findElement(By.className("ico-login"));}
    public WebElement EnterEmailPOM() {return Hooks.driver.findElement(By.xpath("//div[@class=\"form-fields\"]/div[1]/input"));}
    public WebElement PasswordPOM() {return Hooks.driver.findElement(By.xpath("//div[@class=\"form-fields\"]/div[2]/input"));}
    public WebElement loginBttnPOM() {return Hooks.driver.findElement(By.className("login-button"));}
    public WebElement ActualResultMSgPOM() {return Hooks.driver.findElement(By.className("message-error"));}
    public WebElement logoutRegisterPOM() {return Hooks.driver.findElement(By.className("ico-logout"));}
    public WebElement accountTabPOM() {return Hooks.driver.findElement(By.className("ico-account"));}


    public void LO_1_loginLinkPOM(){loginLinkPOM().click();}

    public void LO_2_EnterValidEmailPOM(String ValidEmail, String ValidPassword) throws InterruptedException {
        EnterEmailPOM().click();
        EnterEmailPOM().clear();
        EnterEmailPOM().sendKeys(ValidEmail);

        PasswordPOM().click();
        PasswordPOM().clear();
        PasswordPOM().sendKeys(ValidPassword);
        Thread.sleep(2000);
    }

    public void LO_3_loginBttnPOM() throws InterruptedException {loginBttnPOM().click();Thread.sleep(3000);}

    public void LO_4_SuccessfullLoginPOM(){

        SoftAssert soft = new SoftAssert();

        String actualResultURL = Hooks.driver.getCurrentUrl();
        String expectedResultURL = "https://demo.nopcommerce.com/";
        System.out.println(actualResultURL);
        soft.assertEquals(actualResultURL, expectedResultURL);
        WebElement accountTab = accountTabPOM();
        soft.assertTrue(accountTab.isDisplayed(), String.valueOf(true));

        soft.assertAll();

    }

    public void LO_5_EnterInValidEmailPOM(String InValidEmail, String InValidPassword){
        EnterEmailPOM().click();
        EnterEmailPOM().clear();
        EnterEmailPOM().sendKeys(InValidEmail);

        PasswordPOM().click();
        PasswordPOM().clear();
        PasswordPOM().sendKeys(InValidPassword);
    }

    public void LO_6_UnSuccessfullLoginPOM(){

        SoftAssert soft = new SoftAssert();

        String actualResultMsg = ActualResultMSgPOM().getText();
        String expectedResultMsg = "Login was unsuccessful";
        System.out.println(actualResultMsg);
        soft.assertTrue(actualResultMsg.contains(expectedResultMsg));

        String actualColor = ActualResultMSgPOM().getCssValue("color");
        String expectedColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(expectedColor,"#e4434b");

        soft.assertAll();

    }

    public void LO_7_LogoutPOM(){logoutRegisterPOM().click();}
}
