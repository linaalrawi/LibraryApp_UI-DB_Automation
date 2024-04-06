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
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    private WebElement emailInputBox;

    @FindBy(id = "inputPassword")
    private WebElement passwordInputBox;

    @FindBy(css = "button[type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//img")
    private WebElement libraryLogo;

    @FindBy(xpath = "//p")
    private WebElement copyRightYear;

    @FindBy(xpath = "//label[@for='inputEmail']")
    private WebElement emailInputBoxLabel;

    @FindBy(xpath = "//label[@for='inputPassword']")
    private WebElement passwordInputBoxLabel;

    /**
     * Logs in to the application with the provided username and password.
     *
     * @param username The username to log in with.
     * @param password The password to log in with.
     */
    public void login(String username, String password) {
        BrowserUtils.waitFor(1);
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
    public void login(String userType) {
        BrowserUtils.waitFor(1);
        emailInputBox.sendKeys(ConfigurationReader.getProperty(userType + "_username"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("librarian_password"));
        signInButton.click();
    }

    /**
     * Checks if the library logo is displayed on the login page.
     *
     * @return true if the library logo is displayed, false otherwise.
     */
    public boolean isLogoDisplayed() {
        BrowserUtils.waitFor(1);
        return libraryLogo.isDisplayed();
    }

    /**
     * Retrieves the copyright year displayed on the login page.
     *
     * @return The copyright year displayed on the login page.
     */
    public String getCopyRightYear() {
        BrowserUtils.waitFor(1);
        return copyRightYear.getText().substring(2);
    }

    /**
     * Retrieves the text displayed on the sign-in button.
     *
     * @return The text displayed on the sign-in button.
     */
    public String getSignInButtonText() {
        BrowserUtils.waitFor(1);
        return signInButton.getText();
    }

    /**
     * Retrieves the label text for the email input box.
     *
     * @return The label text for the email input box.
     */
    public String getEmailInputBoxText() {
        BrowserUtils.waitFor(1);
        return emailInputBoxLabel.getText();
    }

    /**
     * Retrieves the label text for the password input box.
     *
     * @return The label text for the password input box.
     */
    public String getPasswordInputBoxText() {
        BrowserUtils.waitFor(1);
        return passwordInputBoxLabel.getText();
    }
}
