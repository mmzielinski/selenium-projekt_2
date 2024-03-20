package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void openMyAccountPage() {
        myAccountLink.click();
    }

}
