package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.module.Configuration;

/**
 * This class represents the Users page of the application.
 * It provides methods to interact with elements on the Users page.
 */
public class UsersPage extends BasePage {

    @FindBy(id = "status")
    private WebElement statusDropdownEditUser;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveChangesButton;

    @FindBy(css = "div.toast-message")
    private WebElement message;

    @FindBy(id = "user_status")
    private WebElement statusDropdownUserManagement;

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//a[@title='Last']")
    private WebElement lastButton;

    /**
     * Initializes the elements of the UsersPage class using PageFactory.
     */
    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Clicks the "Edit" button for a user specified by email.
     *
     * @param email The email of the user.
     */
    public void clickEditUserButtonByEmail(String email) {
        WebElement editUserButton = Driver.getDriver().findElement(
                By.xpath("//td[.='" + email + "']/..//a"));
        editUserButton.click();
    }

    /**
     * Clicks the "Edit" button for a user specified by username.
     *
     * @param username The username of the user.
     */
    public void clickEditUserButtonByUserName(String username){
        WebElement editUserButton = Driver.getDriver().findElement(
                By.xpath("//td[.='" + username + "']/..//a"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(editUserButton).click().perform();
    }

    /**
     * Changes the status of a user on the edit user page.
     *
     * @param oldStatus The old status of the user.
     * @param newStatus The new status to set for the user.
     */
    public void changeStatusEditUser(String oldStatus, String newStatus){
        BrowserUtils.waitFor(3);
        Select select = new Select(statusDropdownEditUser);
        select.selectByValue(newStatus);
    }

    /**
     * Changes the status of a user on the user management page.
     *
     * @param currentStatus The current status of the user.
     * @param newStatus The new status to set for the user.
     */
    public void changeStatusUserManagement(String currentStatus,String newStatus){
        Select select = new Select(statusDropdownUserManagement);
        select.selectByValue(newStatus);
    }

    /**
     * Clicks the "Save Changes" button.
     */
    public void clickSaveChangesButton(){
        saveChangesButton.click();
    }

    /**
     * Gets the text of the message displayed on the page.
     *
     * @return The text of the message.
     */
    public String getMessageText(){
        return message.getText();
    }

    public void clickNextButtonActiveUsers(){
        for (int i = 0; i < 4; i++) {
            BrowserUtils.waitFor(1);
            nextButton.click();
        }
    }
    public void clickLastButtonInactiveUsers(){
        BrowserUtils.waitFor(1);
        lastButton.click();
    }

}
