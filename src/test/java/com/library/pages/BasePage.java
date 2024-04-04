package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the base page of the application.
 * It provides common functionality and elements for all pages.
 */
public abstract class BasePage {

    /**
     * Initializes the elements of the BasePage class using PageFactory.
     */
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    private WebElement userNameField;

    @FindBy(id = "navbarDropdown")
    private WebElement navBarDropdown;

    @FindBy(xpath = "//a[.='Log Out']")
    private WebElement logOutButton;

    /**
     * Navigates to the specified module page.
     *
     * @param moduleName The name of the module to navigate to.
     */
    public void navigatePage(String moduleName){
        WebElement module = Driver.getDriver().findElement(
                By.xpath("//span[@class='title'][.='"+moduleName+"']/.."));
        module.click();
    }

    /**
     * Retrieves the username displayed on the page.
     *
     * @return The username displayed on the page.
     */
    public String getUserName(){
        BrowserUtils.waitFor(2);
        return userNameField.getText();
    }

    /**
     * Logs out of the application.
     */
    public void logOut(){
        navBarDropdown.click();
        logOutButton.click();
    }
}
