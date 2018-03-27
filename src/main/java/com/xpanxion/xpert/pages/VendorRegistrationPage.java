/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.xpert.pages;

import com.xpanxion.base.WebPageBase;
import java.util.List;
import org.openqa.selenium.By;

/**
 *
 * @author xpanxion
 */
public class VendorRegistrationPage extends WebPageBase {

    By inputName = By.id("vendor_name");
    By inputRestaurantName = By.id("kitchen_name");
    By inputAboutYourBusiness = By.id("description");
    By buttonCusineServed = By.cssSelector(".faasos-arrow-right.right");
    By inputAddress = By.id("address");
    By selectCity = By.id("city_id");
    By inputPhoneNumber = By.id("phone_number");
    By inputEmailID = By.id("email_id");
    By inputComment = By.id("comments");
    By buttonSubmit = By.id("vendorRegisterBtn");

    public VendorRegistrationPage enterName(String name) {
        sendValuesToWebElement(waitForElement(inputName), name);
        return this;
    }

    public VendorRegistrationPage enterRestaurant(String name) {
        sendValuesToWebElement(waitForElement(inputRestaurantName), name);
        return this;
    }

    public VendorRegistrationPage enterAboutYourBusiness(String name) {
        sendValuesToWebElement(waitForElement(inputAboutYourBusiness), name);
        return this;
    }

    public VendorRegistrationPage enterAddress(String name) {
        sendValuesToWebElement(waitForElement(inputAddress), name);
        return this;
    }

    public VendorRegistrationPage enterPhoneNumber(String name) {
        sendValuesToWebElement(waitForElement(inputPhoneNumber), name);
        return this;
    }

    public VendorRegistrationPage enterEmailID(String name) {
        sendValuesToWebElement(waitForElement(inputEmailID), name);
        return this;
    }

    public VendorRegistrationPage enterComment(String name) {
        sendValuesToWebElement(waitForElement(inputComment), name);
        return this;
    }

    public VendorRegistrationPage selectCityByText(String name) {
        selectItemByText(waitForElement(selectCity), name);
        return this;
    }

    public <T extends WebPageBase> T submit(Class<T> clazz) {
        try {
            clickButton(waitForElement(buttonSubmit));
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create an instance of the class mentioned");
        }
    }

    public VendorRegistrationPage selectCusineServed(List<String> list) {
        getJavaScriptExecutor().executeScript("arguments[0].click()",waitForElement(buttonCusineServed));
        CusineOptionsPopUp cusineOptionsPopUp = new CusineOptionsPopUp();
        cusineOptionsPopUp.selectCusine(list);
        VendorRegistrationPage registrationPage = new VendorRegistrationPage();
        registrationPage = cusineOptionsPopUp.submitOptions(registrationPage.getClass());
        return registrationPage;
    }

}
