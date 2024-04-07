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

    /**
     * Clicks the "Close" button.
     */
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

    /**
     * Changes the user group on the user management page.
     *
     * @param groupName The name of the group to assign to the user.
     */
    public void changeUserGroupOnUserManagement(String groupName) {
        BrowserUtils.waitFor(1);
        Select select = new Select(userGroupsDropdownOnUserManagement);
        select.selectByValue(groupName);
    }

    /**
     * Changes the user group.
     *
     * @param groupName The name of the group to assign to the user.
     */
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

    /**
     * Clicks the "Add User" button.
     */
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

    /**
     * Retrieves the text of the user group cell on the page.
     *
     * @return The text of the user group cell.
     */
    public String getUserGroup() {
        BrowserUtils.waitFor(1);
        return groupCell.getText();
    }

    /**
     * Retrieves the text of the full name cell on the page.
     *
     * @return The text of the full name cell.
     */
    public String getFullName() {
        BrowserUtils.waitFor(1);
        return fullNameCell.getText();
    }

    /**
     * Retrieves the text of the status cell on the page.
     *
     * @return The text of the status cell.
     */
    public String getStatus() {
        BrowserUtils.waitFor(1);
        return statusCell.getText();
    }

    /**
     * Retrieves the text of the user ID cell on the page.
     *
     * @return The text of the user ID cell.
     */
    public String getUserId() {
        BrowserUtils.waitFor(1);
        return userIdCell.getText();
    }

    /**
     * Enters full name into the full name input box.
     *
     * @param fullName The full name to enter.
     */
    public void enterFullName(String fullName) {
        BrowserUtils.waitFor(1);
        fullNameInputBox.sendKeys(fullName);
    }

    /**
     * Enters password into the password input box.
     *
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        BrowserUtils.waitFor(1);
        passwordInputBox.sendKeys(password);
    }

    /**
     * Enters email into the email input box.
     *
     * @param email The email to enter.
     */
    public void enterEmail(String email) {
        BrowserUtils.waitFor(1);
        emailInputBox.sendKeys(email);
    }

    /**
     * Enters start date into the start date input box.
     *
     * @param startDate The start date to enter.
     */
    public void enterStartDate(String startDate) {
        BrowserUtils.waitFor(1);
        startDateInputBox.sendKeys(startDate);
    }

    /**
     * Enters end date into the end date input box.
     *
     * @param endDate The end date to enter.
     */
    public void enterEndDate(String endDate) {
        BrowserUtils.waitFor(1);
        endDateInputBox.sendKeys(endDate);
    }

    /**
     * Enters address into the address input box.
     *
     * @param address The address to enter.
     */
    public void enterAddress(String address) {
        BrowserUtils.waitFor(1);
        addressInputBox.sendKeys(address);
    }

    /**
     * Clears the text from the full name input box.
     */
    public void deleteFullName(){
        BrowserUtils.waitFor(1);
        fullNameInputBox.clear();
    }

    /**
     * Clears the text from the password input box.
     */
    public void deletePassword(){
        BrowserUtils.waitFor(1);
        passwordInputBox.clear();
    }

    /**
     * Clears the text from the email input box.
     */
    public void deleteEmail(){
        BrowserUtils.waitFor(1);
        emailInputBox.clear();
    }

    /**
     * Clears the text from the start date input box.
     */
    public void deleteStartDate(){
        BrowserUtils.waitFor(1);
        startDateInputBox.clear();
    }

    /**
     * Clears the text from the end date input box.
     */
    public void deleteEndDate(){
        BrowserUtils.waitFor(1);
        endDateInputBox.clear();
    }

    /**
     * Clears the text from the address input box.
     */
    public void deleteAddress(){
        BrowserUtils.waitFor(1);
        addressInputBox.clear();
    }
}
