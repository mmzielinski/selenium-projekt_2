package com.seleniumdemo.tests;

import com.seleniumdemo.pages.*;
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

//        AddressDetailsPage addressDetailsPage = new AddressDetailsPage(driver);
//        addressDetailsPage



    }
}