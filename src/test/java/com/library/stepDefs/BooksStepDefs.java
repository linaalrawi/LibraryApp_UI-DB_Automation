package com.library.stepDefs;

import com.library.pages.BooksPage;
import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BooksStepDefs {

    BooksPage booksPage = new BooksPage();
    List<String> actualBookCategories = new ArrayList<String>();
    List<String> actualBookInformation = new ArrayList<>();
    List<String> expectedBookInformation = new ArrayList<>();
    List<String> expectedBookCategories = new ArrayList<>();
    String actualMessageText;


    @When("the user gets all book categories in webpage")
    public void the_user_gets_all_book_categories_in_webpage() {
        actualBookCategories = booksPage.getAllBookCategories();
    }

    @Then("the user should be able to see following categories")
    public void the_user_should_be_able_to_see_following_categories(List<String> expectedBookCategories) {
        Assert.assertEquals(expectedBookCategories,actualBookCategories);
    }

    @Then("the user verifies that book categories match with book categories table from db")
    public void the_user_verifies_that_book_categories_match_with_book_categories_table_from_db() {
        DataBaseUtils.runQuery("select name from book_categories");
        expectedBookCategories = DataBaseUtils.getColumnDataAsList(1);
        Assert.assertEquals(expectedBookCategories, actualBookCategories);
    }

    @Then("the user verifies that book information matches with database for {string}")
    public void the_user_verifies_that_book_information_matches_with_the_database_for(String bookName) {
        expectedBookInformation = booksPage.getBookInformationOnBookManagement();

        DataBaseUtils.runQuery("select b.name, b.isbn, b.year, b.author, bc.name\n" +
                "from books b\n" +
                "         join book_categories bc\n" +
                "              on b.book_category_id = bc.id\n" +
                "where b.name = '"+bookName+"'\n" +
                "limit 1");

        actualBookInformation = DataBaseUtils.getRowDataAsList(1);
        Assert.assertEquals(expectedBookInformation,actualBookInformation);
    }

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        booksPage.searchBook(bookName);
    }

    @When("the user clicks edit book button by book name {string}")
    public void the_user_clicks_edit_book_button_by_book_name(String bookName) {
        booksPage.clickEditBookButtonByBookName(bookName);
    }

    @Then("the user verifies that book {string} information matches with Database")
    public void the_user_verifies_that_book_information_matches_with_database(String bookName) {
        actualBookInformation = booksPage.getBookInformation();

        DataBaseUtils.runQuery("select b.name, b.isbn, b.year, b.author, b.description,bc.name\n" +
                "from books b join book_categories bc on b.book_category_id = bc.id\n" +
                "where b.name='"+bookName+"'");

        expectedBookInformation = DataBaseUtils.getRowDataAsList(1);
        Assert.assertEquals(expectedBookInformation,actualBookInformation);
    }

    @When("the user clicks to add book")
    public void the_user_clicks_to_add_book() {
        booksPage.clickAddBookButton();
    }

    @When("the user enters book name {string}")
    public void the_user_enters_book_name(String bookName) {
        booksPage.enterBookName(bookName);
    }

    @When("the user enters ISBN {string}")
    public void the_user_enters_isbn(String isbnNumber) {
        booksPage.enterISBN(isbnNumber);
    }

    @When("the user enters year {string}")
    public void the_user_enters_year(String publishedYear) {
        booksPage.enterPublishedYear(publishedYear);
    }

    @When("the user enters author {string}")
    public void the_user_enters_author(String AuthorName) {
        booksPage.enterAuthorName(AuthorName);
    }

    @When("the user chooses the book category {string}")
    public void the_user_chooses_the_book_category(String category) {
        booksPage.selectBookCategory(category);
    }

    @When("the user clicks to save changes")
    public void the_user_clicks_to_save_changes() {
        booksPage.clickSaveChangesButton();
    }

    @Then("the user verifies that {string} message is displayed")
    public void the_user_verifies_that_message_is_displayed(String expectedMessageText) {
        actualMessageText = booksPage.getMessageText();
        Assert.assertEquals(expectedMessageText, actualMessageText);
    }

    @Then("the user verifies that {string} information matches with DB")
    public void the_user_verifies_that_information_matches_with_db(String bookName) {
        booksPage.searchBook(bookName);
        expectedBookInformation = booksPage.getBookInformationOnBookManagement();

        DataBaseUtils.runQuery("select b.name, b.isbn, b.year, b.author, bc.name\n" +
                "from books b\n" +
                "         join book_categories bc\n" +
                "              on b.book_category_id = bc.id\n" +
                "where b.name = '"+bookName+"'\n" +
                "limit 1");

        actualBookInformation = DataBaseUtils.getRowDataAsList(1);
        Assert.assertEquals(expectedBookInformation,actualBookInformation);
    }

    @When("the user clicks Borrow Book button by book name {string}")
    public void the_user_clicks_borrow_book_button_by_book_name(String bookName) {
        booksPage.clickBorrowBookButtonByBookNameIfNotBorrowedByAnyOne(bookName);
    }
}
