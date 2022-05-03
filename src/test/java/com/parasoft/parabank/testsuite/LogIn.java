package com.parasoft.parabank.testsuite;


import com.parasoft.parabank.Pages.AccountOverview_Page;
import com.parasoft.parabank.Pages.HomePage;
import com.parasoft.parabank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn extends TestBase {
    HomePage homePage =new HomePage();
   AccountOverview_Page accountOverviewPage=new AccountOverview_Page();

    public void userShouldLoginSuccessFullyWithValidCredentials() {
        homePage.sendEmailToEmailIdFieldOnHomePage("b12@gmail.com");
       homePage.sendPasswordOnHomePage("123456");
        homePage.clickOnLoginLink();
        String actualTitle=homePage.validateAccountOverView();
        String expectedTitle="Accounts Overview";
        Assert.assertEquals(actualTitle,expectedTitle,"Account overview Title Validation");
    }
    @Test
    public void verifyTheErrorMessage() {
        homePage.sendEmailToEmailIdFieldOnHomePage("np214@gmail.com");
        homePage.clickOnLoginLink();
        String actualMessage=homePage.validateErrorMessage();
        String expectedMessage="Please enter a username and password.";
        Assert.assertEquals(actualMessage,expectedMessage,"Login Error message Validation");
    }
   @Test
    public void userShouldLogOutSuccessfully() {
        // if this test is fail, then first run the "Register test" and in console email Id will be generated
       // those email Id put here in line Number 34 
        homePage.sendEmailToEmailIdFieldOnHomePage("user619@yahoo.com");
        homePage.sendPasswordOnHomePage("123456");
        homePage.clickOnLoginLink();
        accountOverviewPage.clickOnLogOutBtn();
        homePage.validateCustomerLoginText();
    }

}
