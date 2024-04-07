package com.library.stepDefs;

import com.library.pages.BooksPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Set;

public class BooksStepDefs {

    BooksPage booksPage = new BooksPage();

    @When("the user gets all book categories in webpage")
    public void the_user_gets_all_book_categories_in_webpage() {

    }

    @Then("the user should be able to see following categories")
    public void the_user_should_be_able_to_see_following_categories(Set<String> categories) {

    }

    @Then("the user verifies that book categories match with book categories table from db")
    public void the_user_verifies_that_book_categories_match_with_book_categories_table_from_db() {

    }

    @Then("the user verifies that book information matches with database for {string}")
    public void the_user_verifies_that_book_information_matches_with_the_database_for(String bookName) {

    }

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {

    }

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {

    }

    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {

    }

    @Then("the user verifies that book information matches with Database")
    public void the_user_verifies_that_book_information_matches_with_database() {

    }

    @When("the user clicks to add book")
    public void the_user_clicks_to_add_book() {

    }

    @When("the user enters book name {string}")
    public void the_user_enters_book_name(String bookName) {

    }

    @When("the user enters ISBN {string}")
    public void the_user_enters_isbn(String isbnNumber) {

    }

    @When("the user enters year {string}")
    public void the_user_enters_year(String publishedYear) {

    }

    @When("the user enters author {string}")
    public void the_user_enters_author(String AuthorName) {

    }

    @When("the user chooses the book category {string}")
    public void the_user_chooses_the_book_category(String category) {

    }

    @When("the user clicks to save changes")
    public void the_user_clicks_to_save_changes() {

    }

    @Then("the user verifies that {string} message is displayed")
    public void the_user_verifies_that_message_is_displayed(String messageText) {

    }

    @Then("the user verifies that {string} information matches with DB")
    public void the_user_verifies_that_information_matches_with_db(String bookName) {

    }

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {

    }
}
