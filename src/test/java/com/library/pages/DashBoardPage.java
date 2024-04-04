package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the Dashboard page of the application.
 * It provides methods to interact with elements on the Dashboard page.
 */
public class DashBoardPage extends BasePage{

    @FindBy(id = "borrowed_books")
    private WebElement borrowedBooksCount;

    @FindBy(id = "user_count")
    private WebElement usersCount;

    @FindBy(id = "book_count")
    private WebElement booksCount;

    /**
     * Initializes the elements of the DashBoardPage class using PageFactory.
     */
    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * Retrieves the count of borrowed books displayed on the Dashboard page.
     *
     * @return The count of borrowed books.
     */
    public String getBorrowedBooksCount(){
        BrowserUtils.waitFor(2);
        return borrowedBooksCount.getText();
    }

    /**
     * Retrieves the count of users displayed on the Dashboard page.
     *
     * @return The count of users.
     */
    public String getUsersCount(){
        BrowserUtils.waitFor(2);
        return usersCount.getText();
    }

    /**
     * Retrieves the count of books displayed on the Dashboard page.
     *
     * @return The count of books.
     */
    public String getBooksCount(){
        BrowserUtils.waitFor(2);
        return booksCount.getText();
    }
}
