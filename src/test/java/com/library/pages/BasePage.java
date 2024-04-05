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

    @FindBy(xpath = "//span[@class='text-muted']//strong")
    private WebElement libraryVersionText;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    private WebElement libraryLogo;

    /**
     * Navigates to the specified module page.
     *
     * @param moduleName The name of the module to navigate to.
     */
    public void navigatePage(String moduleName){

        BrowserUtils.waitFor(1);
        WebElement module = Driver.getDriver().findElement(
                By.xpath("//span[@class='title'][.='"+moduleName+"']/.."));
        module.click();
    }

    /**
     * Retrieves the text of a specific module displayed on the page.
     *
     * @param moduleName The name of the module to retrieve text for.
     * @return The text of the specified module.
     */
    public String getModuleText(String moduleName){
        BrowserUtils.waitFor(1);
        WebElement module = Driver.getDriver().findElement(
                By.xpath("//span[.='"+moduleName+"']"));

        return module.getText();
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
        BrowserUtils.waitFor(1);
        navBarDropdown.click();
        BrowserUtils.waitFor(1);
        logOutButton.click();
    }

    /**
     * Retrieves the version text of the library displayed on the page.
     *
     * @return The version text of the library.
     */
    public String getVersionText(){
        BrowserUtils.waitFor(1);
        return libraryVersionText.getText();
    }

    /**
     * Retrieves the text of the library logo displayed on the page.
     *
     * @return The text of the library logo.
     */
    public String getLogoText(){
        BrowserUtils.waitFor(1);
        return libraryLogo.getText();
    }

    /**
     * Retrieves the text of the logout button displayed on the page.
     *
     * @return The text of the logout button.
     */
    public String getLogOutButtonText(){
        BrowserUtils.waitFor(1);
        return logOutButton.getText();
    }
}
