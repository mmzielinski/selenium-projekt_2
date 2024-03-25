package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddressDetailsPage {


    @FindBy(id = "billing_first_name")
    private WebElement inputFirstName;

    @FindBy(id = "billing_last_name")
    private WebElement inputLastName;

    @FindBy(id = "billing_country")
    private WebElement selectCountry;

    @FindBy(id = "billing_address_1")
    private WebElement inputAddress;

    @FindBy(id = "billing_postcode")
    private WebElement inputPostcode;

    @FindBy(id = "billing_city")
    private WebElement inputCity;

    @FindBy(id = "billing_phone")
    private WebElement inputPhone;

    @FindBy(id = "billing_email")
    private WebElement inputEmail;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;


    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage addressDetails(Customer customer) {
        inputFirstName.sendKeys(customer.getFirstName());
        inputLastName.sendKeys(customer.getLastName());
        Select countrySelect = new Select(selectCountry);
        countrySelect.selectByVisibleText(customer.getCountry());
        inputAddress.sendKeys(customer.getAddress());
        inputPostcode.sendKeys(customer.getPostcode());
        inputCity.sendKeys(customer.getCity());
        inputPhone.sendKeys(customer.getPhone());
        inputEmail.sendKeys(customer.getEmail());

        try {
            placeOrderButton.click();
        } catch (StaleElementReferenceException e) {
            placeOrderButton = driver.findElement(By.id("place_order"));
        }

        placeOrderButton.click();
        return new OrderDetailsPage(driver);
    }
}