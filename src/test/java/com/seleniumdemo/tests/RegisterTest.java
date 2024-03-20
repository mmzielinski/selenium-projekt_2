package com.seleniumdemo.tests;


import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.LoggedUserPage;
import com.seleniumdemo.pages.MyAccountPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        int random = (int) (Math.random()*1000);
        String email = "test" + random + "@testerski.pl";
        myAccountPage.registerUserValidData(email, "test@testerski.pl");

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        WebElement dashboardLink = loggedUserPage.getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }


    @Test
    public void registerUserWithSameEmailTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.registerUserInvalidData("test1@testerski.pl", "test@testerski.pl");

        WebElement error = myAccountPage.getError();
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address"));
    }
}