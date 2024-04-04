package com.library.stepDefs;

import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user logged in  {string} and {string}")
    public void the_user_logged_in_and(String email, String password) {
        loginPage.login(email, password);
    }

    @When("user gets username  from user fields")
    public void user_gets_username_from_user_fields() {

    }

    @Then("the username should be same with database")
    public void the_username_should_be_same_with_database() {

    }
}
