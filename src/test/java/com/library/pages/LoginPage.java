package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the LoginPage of the application.
 * It provides methods to interact with the login page elements.
 */
public class LoginPage {

    /**
     * Initializes the elements of the LoginPage class using PageFactory.
     */
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    private WebElement emailInputBox;

    @FindBy(id = "inputPassword")
    private WebElement passwordInputBox;

    @FindBy(css = "button[type='submit']")
    private WebElement signInButton;

    /**
     * Logs in to the application with the provided username and password.
     *
     * @param username The username to log in with.
     * @param password The password to log in with.
     */
    public void login(String username, String password){
        emailInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }

    /**
     * Logs in to the application with the username and password retrieved from the configuration file based on the userType.
     * The password is retrieved from the configuration file.
     *
     * @param userType The type of user to log in as.
     */
    public void login(String userType){
        emailInputBox.sendKeys(ConfigurationReader.getProperty(userType+"_username"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        signInButton.click();
    }
}
