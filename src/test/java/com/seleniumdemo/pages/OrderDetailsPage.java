package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class OrderDetailsPage {

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}