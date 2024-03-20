package com.seleniumdemo.tests;


import com.seleniumdemo.pages.HomePage;
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
        myAccountPage.registerUser("test11@testerski.pl", "test11@testerski.pl");

        WebElement dashboardLink = myAccountPage.getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }
}
