package com.parasoft.parabank.testsuite;


import com.parasoft.parabank.Pages.HomePage;
import com.parasoft.parabank.Pages.SignUp_Page;
import com.parasoft.parabank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register extends TestBase {
   HomePage homPage = new HomePage();
    SignUp_Page signUpPage = new SignUp_Page();

    @Test
    public void verifyThatSigningUpPageDisplay() {
        homPage.clickOnRegisterLink();
        String actualText = signUpPage.VerifySignUpText();
        String expectedText = "Signing up is easy!";
        Assert.assertEquals(actualText, expectedText, "Verify SignUp Text");
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        homPage.clickOnRegisterLink();
        signUpPage.enterFirstName("kim");
        signUpPage.enterLastname("john");
        signUpPage.enterAddress("555 unkwn street");
        signUpPage.enterCityName("newyork");
        signUpPage.enterStateName("ohio");
        signUpPage.enterZipCode("545343");
        signUpPage.enterPhoneNumber("98989467498");
        signUpPage.enterSnnNumber("126874");
        signUpPage.sendEmailToEmailIdField();
        signUpPage.enterPassword("123456");
        signUpPage.enterConfirmedPassword("123456");
        signUpPage.clickOnRegisterButton();
        String actualText=signUpPage.verifyAccountCreatedSuccessfully();
        String expectedText="Your account was created successfully. You are now logged in.";
        Assert.assertEquals(actualText,expectedText,"account successfully created text");
    }
}
