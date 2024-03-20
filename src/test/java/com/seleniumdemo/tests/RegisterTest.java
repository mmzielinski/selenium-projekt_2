package com.seleniumdemo.tests;


import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccountPage;
import org.testng.annotations.Test;


public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.registerUser("test123@testerski.pl", "test123@testerski.pl");

    }
}
