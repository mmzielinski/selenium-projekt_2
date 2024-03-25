package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openShopPage();

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.openProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        productPage.viewCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.openCheckoutPage();

        Customer customer = new Customer();
        AddressDetailsPage addressDetailsPage = new AddressDetailsPage(driver);
        addressDetailsPage.addressDetails(customer);

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.getProductName();
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver  × 1");



    }
}