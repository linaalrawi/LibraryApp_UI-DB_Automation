package com.library.stepDefs;

import com.library.pages.BorrowingBooksPage;
import io.cucumber.java.en.Then;

public class BorrowingBooksStepDefs {

    BorrowingBooksPage borrowingBooksPage = new BorrowingBooksPage();

    @Then("the user verifies that book is shown in {string} page")
    public void the_user_verifies_that_book_is_shown_in_page(String moduleName) {

    }

    @Then("the user verifies that student has same book in database")
    public void the_user_verifies_that_student_has_same_book_in_database() {

    }
}
