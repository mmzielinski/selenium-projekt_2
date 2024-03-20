package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement inputRegEmail;

    @FindBy(id = "reg_password")
    private WebElement inputRegPassword;

    @FindBy(name = "register")
    private WebElement clickRegButton;

    @FindBy (linkText = "Dashboard")
    private WebElement dashboardLink;


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void registerUser(String email, String password) {
        inputRegEmail.sendKeys(email);
        inputRegPassword.sendKeys(password);
        clickRegButton.click();
    }

    public WebElement getDashboardLink() {
        return dashboardLink;
    }
}