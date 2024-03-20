package com.seleniumdemo.tests;


import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.LoggedUserPage;
import com.seleniumdemo.pages.MyAccountPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.logInValidData("test1@testerski.pl", "test1@testerski.pl");

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        WebElement dashboardLink = loggedUserPage.getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }


    @Test
    public void logInWithInvalidPasswordlTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.logInInvalidData("test1@testerski.pl", "bledne-haslo");

        WebElement error = myAccountPage.getError();
        Assert.assertTrue(error.getText().contains("Incorrect username or password."));
    }
}