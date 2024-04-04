package com.library.stepDefs;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardStepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String usersCount;
    String borrowedBooksCount;
    String booksCount;

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        loginPage.login(userType);
    }

    @When("user gets all information from modules")
    public void user_gets_all_information_from_modules() {
        usersCount = dashBoardPage.getFieldCount("Users");
        borrowedBooksCount = dashBoardPage.getFieldCount("Borrowed Books");
        booksCount = dashBoardPage.getFieldCount("Books");
    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {

    }

}
