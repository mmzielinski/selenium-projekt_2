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

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;


    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    private WebDriver driver;

    private void registerUser(String email, String password) {
        inputRegEmail.sendKeys(email);
        inputRegPassword.sendKeys(password);
        clickRegButton.click();
    }

    public WebElement getError() {
        return error;
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        return this;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }


    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }
}