package com.parasoft.parabank.Pages;


import com.parasoft.parabank.utility.Utility;
import org.openqa.selenium.By;

public class AccountOverview_Page extends Utility {
    By logOut=By.xpath("//div[@id='leftPanel']/ul/li[8]/a");


    public void clickOnLogOutBtn(){
        clickOnElement(logOut);
    }
}
