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

    @When("the user gets all information from modules")
    public void the_user_gets_all_information_from_modules() {
        actualUsersCount = dashBoardPage.getUsersCount();
        actualBorrowedBooksCount = dashBoardPage.getBorrowedBooksCount();
        actualBooksCount = dashBoardPage.getBooksCount();
    }

    @Then("the user verifies that the information matches with database")
    public void the_user_verifies_that_the_information_matches_with_database() {
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

    @When("the user gets borrowed books number")
    public void the_user_gets_borrowed_books_number() {
        actualBorrowedBooksCount = dashBoardPage.getBorrowedBooksCount();
    }

    @Then("the user verifies that the borrowed books number matches with DB")
    public void the_user_verifies_that_the_borrowed_books_number_matches_with_db() {
        DataBaseUtils.runQuery("select count(*) from book_borrow\n" +
                "where is_returned=0");

        expectedBorrowedBooksCount = DataBaseUtils.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBooksCount,actualBorrowedBooksCount);
    }
}
