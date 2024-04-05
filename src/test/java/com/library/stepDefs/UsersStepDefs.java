package com.library.stepDefs;

import com.library.pages.UsersPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UsersStepDefs {

    UsersPage usersPage = new UsersPage();
    String expectedStatus;
    String actualStatus;
    String email;

    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        usersPage.navigatePage(moduleName);
    }

    @When("the user clicks Edit User button")
    public void the_user_clicks_edit_user_button() {
        usersPage.clickNextButtonActiveUsers();
        usersPage.clickEditUserButtonByEmail(ConfigurationReader.getProperty("librarian_username"));
        email = ConfigurationReader.getProperty("librarian_username");
    }

    @When("the user changes user status {string} to {string}")
    public void the_user_changes_user_status_to(String oldStatus, String newStatus) {
        usersPage.changeStatusEditUser(oldStatus,newStatus);
        expectedStatus = newStatus;
    }

    @When("the user clicks save changes button")
    public void the_user_clicks_save_changes_button() {
        usersPage.clickSaveChangesButton();
    }

    @Then("{string} message should appear")
    public void message_should_appear(String expectedMessage) {
        Assert.assertEquals(expectedMessage,usersPage.getMessageText());
    }

    @Then("the users should see same status for related user in database")
    public void the_users_should_see_same_status_for_related_user_in_database() {
        DataBaseUtils.runQuery("select status from users where email='"+email+"'");
        actualStatus = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedStatus,actualStatus);
    }

    @Then("the user changes current user status {string} to {string}")
    public void the_user_changes_current_user_status_to(String oldStatus, String newStatus) {
        usersPage.changeStatusUserManagement(newStatus,oldStatus);
        usersPage.clickLastButtonInactiveUsers();
        usersPage.clickEditUserButtonByUserName(usersPage.getUserName());
        usersPage.changeStatusEditUser(oldStatus,newStatus);
        usersPage.clickSaveChangesButton();
    }
}
