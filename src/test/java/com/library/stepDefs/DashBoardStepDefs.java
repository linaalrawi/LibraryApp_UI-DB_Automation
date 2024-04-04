package com.library.stepDefs;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashBoardStepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualUsersCount;
    String actualBorrowedBooksCount;
    String actualBooksCount;
    String expectedUsersCount;
    String expectedBorrowedBooksCount;
    String expectedBooksCount;

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        loginPage.login(userType);
    }

    @When("user gets all information from modules")
    public void user_gets_all_information_from_modules() {
        actualUsersCount = dashBoardPage.getUsersCount();
        actualBorrowedBooksCount = dashBoardPage.getBorrowedBooksCount();
        actualBooksCount = dashBoardPage.getBooksCount();
    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
        DataBaseUtils.runQuery("select count(*) from books");
        expectedBooksCount = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBooksCount,actualBooksCount);

        DataBaseUtils.runQuery("select count(*) from users");
        expectedUsersCount = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedUsersCount,actualUsersCount);

        DataBaseUtils.runQuery("select count(*) from book_borrow where is_returned=0");
        expectedBorrowedBooksCount = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBooksCount,actualBorrowedBooksCount);
    }
}
