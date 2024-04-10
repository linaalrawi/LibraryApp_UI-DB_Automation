package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This class represents the Borrowing Books page of the application.
 * It provides methods to interact with elements on the Borrowing Books page.
 */
public class BorrowingBooksPage extends BasePage{

    /**
     * Initializes the elements of the BorrowingBooksPage class using PageFactory.
     */
    public BorrowingBooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_list")
    private WebElement usersDropdown;

    @FindBy(xpath = "//a[.=' Return Book']")
    private WebElement returnBookButton;

    @FindBy(css = "div.toast-message")
    private WebElement toastMessage;

    @FindBy(xpath = "//td[2]")
    private WebElement bookNameCell;

    @FindBy(xpath = "//td[3]")
    private WebElement borrowedDayCell;

    @FindBy(xpath = "//td[4]")
    private WebElement plannedReturnDateCell;

    @FindBy(xpath = "//td[5]")
    private WebElement returnDateCell;

    @FindBy(xpath = "//td[6]")
    private WebElement returnStatusCell;

    /**
     * Checks whether a book with the specified name is displayed.
     *
     * @param bookName The name of the book to check.
     * @return `true` if the book is displayed, `false` otherwise.
     */
    public boolean isBookShown(String bookName){
        BrowserUtils.waitFor(1);
        WebElement bookInfoRow = Driver.getDriver().findElement(
                By.xpath("//td[.='null']/..//td[.='"+bookName+"']/.."));

        return bookInfoRow.isDisplayed();
    }

    /**
     * Clicks the "Return Book" button by book name.
     *
     * @param bookName the book name that will return.
     */
    public void clickReturnButtonByBookName(String bookName) {
        BrowserUtils.waitFor(1);
        WebElement returnBookButton = Driver.getDriver().findElement(
                By.xpath("//td[.='null']/..//td[.='" + bookName + "']/..//a")
        );
        returnBookButton.click();
    }

    /**
     * Selects a student from the users dropdown.
     *
     * @param user The name of the student to select.
     */
    public void selectStudent(String user){
        BrowserUtils.waitFor(1);
        Select studentDropdown = new Select(usersDropdown);
        studentDropdown.selectByVisibleText(user);
    }

    /**
     * Gets the name of the student selected in the dropdown.
     *
     * @return The name of the selected student.
     */
    public String getStudentNameFromDropdown(){
        BrowserUtils.waitFor(1);
        Select select = new Select(usersDropdown);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Gets the text of the message displayed on the page.
     *
     * @return The text of the message.
     */
    public String getMessageText(){
        BrowserUtils.waitFor(1);
        return toastMessage.getText();
    }

    /**
     * Gets the name of the borrowed book.
     *
     * @return The name of the borrowed book.
     */
    public String getBookName(){
        BrowserUtils.waitFor(1);
        return bookNameCell.getText();
    }

    /**
     * Gets the date the book was borrowed.
     *
     * @return The borrowed day.
     */
    public String getBorrowedDay(){
        BrowserUtils.waitFor(1);
        return borrowedDayCell.getText();
    }

    /**
     * Gets the planned return date of the book.
     *
     * @return The planned return date.
     */
    public String getPlannedReturnDate(){
        BrowserUtils.waitFor(1);
        return plannedReturnDateCell.getText();
    }

    /**
     * Gets the actual return date of the book.
     *
     * @return The return date.
     */
    public String getReturnDate(){
        BrowserUtils.waitFor(1);
        return returnDateCell.getText();
    }

    /**
     * Gets the return status of the book.
     *
     * @return The return status.
     */
    public String getReturnStatus(){
        BrowserUtils.waitFor(1);
        return returnStatusCell.getText();
    }
}
