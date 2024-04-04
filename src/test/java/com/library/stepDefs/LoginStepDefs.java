package com.library.stepDefs;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualUserName;
    String expectedUserName;
    String email;

    @Given("the user logged in  {string} and {string}")
    public void the_user_logged_in_and(String email, String password) {
        loginPage.login(email, password);
        this.email = email;
    }

    @When("user gets username  from user fields")
    public void user_gets_username_from_user_fields() {
        actualUserName = dashBoardPage.getUserName();
    }

    @Then("the username should be same with database")
    public void the_username_should_be_same_with_database() {
        DataBaseUtils.runQuery("select full_name from users where email='"+email+"'");
        expectedUserName = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedUserName,actualUserName);
    }
}
