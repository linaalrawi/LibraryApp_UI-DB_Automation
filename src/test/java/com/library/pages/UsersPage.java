package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This class represents the Users page of the application.
 * It provides methods to interact with elements on the Users page.
 */
public class UsersPage extends BasePage {

    /**
     * Initializes the elements of the UsersPage class using PageFactory.
     */
    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_status")
    private WebElement statusDropdownOnUserManagement;

    @FindBy(id = "user_groups")
    private WebElement userGroupsDropdownOnUserManagement;

    @FindBy(id = "user_group_id")
    private WebElement userGroupDropdown;

    @FindBy(id = "status")
    private WebElement statusDropdown;

    @FindBy(xpath = "//button[@type='cancel']")
    private WebElement closeButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveChangesButton;

    @FindBy(css = "div.toast-message")
    private WebElement toastMessage;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@name='full_name']")
    private WebElement fullNameInputBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='start_date']")
    private WebElement startDateInputBox;

    @FindBy(xpath = "//input[@name='end_date']")
    private WebElement endDateInputBox;

    @FindBy(id = "address")
    private WebElement addressInputBox;

    @FindBy(xpath = "//a[.=' Edit User']")
    private WebElement editUserButton;

    @FindBy(xpath = "//a[.=' Add User']")
    private WebElement addUserButton;

    @FindBy(xpath = "//td[4]")
    private WebElement emailCell;

    @FindBy(xpath = "//td[2]")
    private WebElement userIdCell;

    @FindBy(xpath = "//td[3]")
    private WebElement fullNameCell;

    @FindBy(xpath = "//td[5]")
    private WebElement groupCell;

    @FindBy(xpath = "//td[6]")
    private WebElement statusCell;

    /**
     * Clicks the "Edit User" button.
     */
    public void clickEditUserButton() {
        BrowserUtils.waitFor(1);
        editUserButton.click();
    }

    public void clickCloseButton(){
        BrowserUtils.waitFor(1);
        closeButton.click();
    }

    /**
     * Changes the status of a user on the edit user page.
     *
     * @param currentStatus The old status of the user.
     * @param newStatus     The new status to set for the user.
     */
    public void changeStatus(String currentStatus, String newStatus) {
        BrowserUtils.waitFor(1);
        Select select = new Select(statusDropdown);
        select.selectByValue(newStatus);
    }

    /**
     * Changes the status of a user on the user management page.
     *
     * @param currentStatus The current status of the user.
     * @param newStatus     The new status to set for the user.
     */
    public void changeStatusOnUserManagement(String currentStatus, String newStatus) {
        BrowserUtils.waitFor(1);
        Select select = new Select(statusDropdownOnUserManagement);
        select.selectByValue(newStatus);
    }

    public void changeUserGroupOnUserManagement(String groupName) {
        BrowserUtils.waitFor(1);
        Select select = new Select(userGroupsDropdownOnUserManagement);
        select.selectByValue(groupName);
    }

    public void changeUserGroup(String groupName) {
        BrowserUtils.waitFor(1);
        Select select = new Select(userGroupDropdown);
        select.selectByValue(groupName);
    }

    /**
     * Clicks the "Save Changes" button.
     */
    public void clickSaveChangesButton() {
        BrowserUtils.waitFor(1);
        saveChangesButton.click();
    }

    /**
     * Gets the text of the message displayed on the page.
     *
     * @return The text of the message.
     */
    public String getMessageText() {
        BrowserUtils.waitFor(1);
        return toastMessage.getText();
    }

    /**
     * Enters text into the search box to search for a user.
     *
     * @param searchText The text to search for.
     */
    public void searchUser(String searchText) {
        BrowserUtils.waitFor(1);
        searchBox.sendKeys(searchText);
    }


    public void clickAddUserButton() {
        BrowserUtils.waitFor(1);
        addUserButton.click();
    }



    /**
     * Retrieves the text of the email cell on the page.
     *
     * @return The text of the email cell.
     */
    public String getEmail() {
        BrowserUtils.waitFor(1);
        return emailCell.getText();
    }

    public String getUserGroup() {
        BrowserUtils.waitFor(1);
        return groupCell.getText();
    }

    public String getFullName() {
        BrowserUtils.waitFor(1);
        return fullNameCell.getText();
    }

    public String getStatus() {
        BrowserUtils.waitFor(1);
        return statusCell.getText();
    }

    public String getUserId() {
        BrowserUtils.waitFor(1);
        return userIdCell.getText();
    }

    public void enterFullName(String fullName) {
        BrowserUtils.waitFor(1);
        fullNameInputBox.sendKeys(fullName);
    }

    public void enterPassword(String password) {
        BrowserUtils.waitFor(1);
        passwordInputBox.sendKeys(password);
    }

    public void enterEmail(String email) {
        BrowserUtils.waitFor(1);
        emailInputBox.sendKeys(email);
    }

    public void enterStartDate(String startDate) {
        BrowserUtils.waitFor(1);
        startDateInputBox.sendKeys(startDate);
    }

    public void enterEndDate(String endDate) {
        BrowserUtils.waitFor(1);
        endDateInputBox.sendKeys(endDate);
    }

    public void enterAddress(String address) {
        BrowserUtils.waitFor(1);
        addressInputBox.sendKeys(address);
    }


}
