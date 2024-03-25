package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductListPage {

    @FindBy(xpath = "//h2[text()='Java Selenium WebDriver']")
    private WebElement productTitle;

    private final WebDriver driver;


    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public ProductPage openProduct() {
        productTitle.click();
        return new ProductPage(driver);
    }


}
