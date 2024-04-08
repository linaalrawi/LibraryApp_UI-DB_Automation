package com.library.stepDefs;

import com.library.pages.UsersPage;
import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UsersStepDefs {

    UsersPage usersPage = new UsersPage();
    String expectedStatus;
    String actualStatus;
    String actualMessage;
    String email;



    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        usersPage.navigatePage(moduleName);
    }

    @When("the user clicks Edit User button")
    public void the_user_clicks_edit_user_button() {
        usersPage.searchUser(usersPage.getUserName());
        email = usersPage.getEmail();
        usersPage.clickEditUserButton();
    }

    @When("the user changes user status {string} to {string}")
    public void the_user_changes_user_status_to(String oldStatus, String newStatus) {
        usersPage.changeStatus(oldStatus,newStatus);
        expectedStatus = newStatus;
    }

    @When("the user clicks save changes button")
    public void the_user_clicks_save_changes_button() {
        usersPage.clickSaveChangesButton();
    }

    @Then("the user verifies that the {string} message is displayed")
    public void the_user_verifies_that_the_message_is_displayed(String expectedMessage) {
        actualMessage = usersPage.getMessageText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("the user verifies that status information matches with database")
    public void the_user_verifies_that_status_information_matches_with_database() {
        DataBaseUtils.runQuery("select status from users where email='"+email+"'");
        actualStatus = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedStatus,actualStatus);
    }

    @Then("the user changes current user status {string} to {string}")
    public void the_user_changes_current_user_status_to(String oldStatus, String newStatus) {
        usersPage.changeStatusOnUserManagement(newStatus,oldStatus);
        usersPage.searchUser(usersPage.getUserName());
        usersPage.clickEditUserButton();
        usersPage.changeStatus(oldStatus,newStatus);
        usersPage.clickSaveChangesButton();
    }
}
