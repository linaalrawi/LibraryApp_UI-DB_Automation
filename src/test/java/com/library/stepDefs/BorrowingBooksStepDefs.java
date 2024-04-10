package com.library.stepDefs;

import com.library.pages.BorrowingBooksPage;
import com.library.utilities.DataBaseUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BorrowingBooksStepDefs {

    BorrowingBooksPage borrowingBooksPage = new BorrowingBooksPage();
    List<String> actualUserAndBorrowedBookInformation = new ArrayList<String>();
    List<String> expectedUserAndBorrowedBookInformation = new ArrayList<String>();
    String expectedUserName;

    @Then("the user verifies that book {string} is shown in {string} page")
    public void the_user_verifies_that_book_is_shown_in_page(String bookName, String moduleName) {
        borrowingBooksPage.navigatePage(moduleName);
        Assert.assertTrue(borrowingBooksPage.isBookShown(bookName));
    }

    @Then("the user verifies that student has same book {string} in database")
    public void the_user_verifies_that_student_has_same_book_in_database(String expectedBookName) {
        expectedUserName = borrowingBooksPage.getUserName();

        expectedUserAndBorrowedBookInformation.addAll(Arrays.asList(
                expectedUserName,
                expectedBookName
        ));

        System.out.println(expectedUserAndBorrowedBookInformation);

        DataBaseUtils.runQuery("select u.full_name,\n" +
                "       b.name\n" +
                "from books b\n" +
                "         join book_borrow bb\n" +
                "              on b.id = bb.book_id\n" +
                "         join users u on bb.user_id = u.id\n" +
                "\n" +
                "where u.full_name = '"+expectedUserName+"'\n" +
                "  and b.name = '"+ expectedBookName +"'\n" +
                "  and bb.is_returned = 0\n" +
                "limit 1");

        actualUserAndBorrowedBookInformation = DataBaseUtils.getRowDataAsList(1);
        System.out.println(actualUserAndBorrowedBookInformation);

        Assert.assertEquals(
                expectedUserAndBorrowedBookInformation,
                actualUserAndBorrowedBookInformation
        );
    }

    @And("the user return the book {string}")
    public void the_user_return_the_book(String bookName) {
        borrowingBooksPage.clickReturnButtonByBookName(bookName);
    }
}
