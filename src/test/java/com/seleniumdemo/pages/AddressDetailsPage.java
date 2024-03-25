package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AddressDetailsPage {


    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
