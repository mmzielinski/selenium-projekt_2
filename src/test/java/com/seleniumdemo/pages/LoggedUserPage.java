package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoggedUserPage {

    @FindBy(id = "username")
    private WebElement inputLogEmail;

    @FindBy(id = "password")
    private WebElement inputLogPassword;

    @FindBy(name = "login")
    private WebElement logInButton;


    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void loginUser(String email, String password) {
        inputLogEmail.sendKeys(email);
        inputLogPassword.sendKeys(password);
        logInButton.click();
    }


}
