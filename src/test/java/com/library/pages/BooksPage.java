package com.library.pages;

import com.library.utilities.BrowserUtils;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the Books page of the application.
 * It provides methods to interact with elements on the Books page.
 */
public class BooksPage extends BasePage {

    /**
     * Initializes the elements of the BooksPage class using PageFactory.
     */
    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "book_categories")
    private WebElement bookCategoriesDropdown;

    @FindBy(xpath = "//a[.=' Add Book']")
    private WebElement addBookButton;

    @FindBy(xpath = "//a[.=' Edit Book']")
    private WebElement editBookButton;

    @FindBy(xpath = "//a[.=' Borrow Book']")
    private WebElement BorrowBookButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//select[@name='tbl_books_length']")
    private WebElement showRecordsDropdown;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement bookNameInputBox;

    @FindBy(xpath = "//input[@name='isbn']")
    private WebElement isbnInputBox;

    @FindBy(xpath = "//input[@name='year']")
    private WebElement publishedYearInputBox;

    @FindBy(xpath = "//input[@name='author']")
    private WebElement authorNameInputBox;

    @FindBy(id = "book_group_id")
    private WebElement bookCategoryDropdown;

    @FindBy(id = "description")
    private WebElement bookDescriptionTextArea;

    @FindBy(xpath = "//button[@type='cancel']")
    private WebElement closeButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveChangesButton;

    @FindBy(css = "div.toast-message")
    private WebElement toastMessage;

    @FindBy(xpath = "//td[2]")
    private WebElement isbnCell;

    @FindBy(xpath = "//td[3]")
    private WebElement bookNameCell;

    @FindBy(xpath = "//td[4]")
    private WebElement authorNameCell;

    @FindBy(xpath = "//td[5]")
    private WebElement categoryCell;

    @FindBy(xpath = "//td[6]")
    private WebElement publishedYearCell;

    @FindBy(xpath = "//td[7]")
    private WebElement borrowedByCell;


    /**
     * Clicks the "Edit Book" button.
     */
    public void clickEditBookButton() {
        BrowserUtils.waitFor(1);
        editBookButton.click();
    }

    /**
     * Clicks the "Add Book" button.
     */
    public void clickAddBookButton() {
        BrowserUtils.waitFor(1);
        addBookButton.click();
    }

    /**
     * Clicks the "Borrow Book" button.
     */
    public void clickBorrowBookButton() {
        BrowserUtils.waitFor(1);
        BorrowBookButton.click();
    }

    /**
     * Clicks the "Save Changes" button.
     */
    public void clickSaveChangesButton() {
        BrowserUtils.waitFor(1);
        saveChangesButton.click();
    }

    /**
     * Clicks the "Close" button.
     */
    public void clickCloseButton() {
        BrowserUtils.waitFor(1);
        closeButton.click();
    }

    /**
     * Gets the book name from the input box on the Edit Book section.
     *
     * @return The book name.
     */
    public String getBookNameOnEditBook() {
        BrowserUtils.waitFor(1);
        return bookNameInputBox.getAttribute("value");
    }

    /**
     * Gets the author name from the input box on the Edit Book section.
     *
     * @return The author name.
     */
    public String getAuthorNameOnEditBook() {
        BrowserUtils.waitFor(1);
        return authorNameInputBox.getAttribute("value");
    }

    /**
     * Gets the published year from the input box on the Edit Book section.
     *
     * @return The published year.
     */
    public String getPublishedYearOnEditBook() {
        BrowserUtils.waitFor(1);
        return publishedYearInputBox.getAttribute("value");
    }

    /**
     * Gets the description from the text area on the Edit Book section.
     *
     * @return The description.
     */
    public String getDescriptionOnEditBook() {
        BrowserUtils.waitFor(1);
        return bookDescriptionTextArea.getText();
    }

    /**
     * Gets the ISBN from the input box on the Edit Book section.
     *
     * @return The ISBN.
     */
    public String getIsbnOnEditBook() {
        BrowserUtils.waitFor(1);
        return isbnInputBox.getAttribute("value");
    }

    /**
     * Gets the information of the book being edited.
     *
     * @return A list containing the book information.
     */
    public List<String> getBookInformation() {

        List<String> bookInformation = new ArrayList<String>();
        bookInformation.addAll(Arrays.asList(
                getBookNameOnEditBook(),
                getIsbnOnEditBook(),
                getPublishedYearOnEditBook(),
                getAuthorNameOnEditBook(),
                getDescriptionOnEditBook(),
                getCategoryOnEditBook()
        ));

        return bookInformation;
    }

    /**
     * Gets the category of the book being edited.
     *
     * @return The category.
     */
    public String getCategoryOnEditBook() {
        BrowserUtils.waitFor(1);
        Select select = new Select(bookCategoryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Selects a book category from the dropdown.
     *
     * @param category The category to select.
     */
    public void selectBookCategories(String category) {
        BrowserUtils.waitFor(1);
        Select select = new Select(bookCategoriesDropdown);
        select.deselectByVisibleText(category);
    }

    /**
     * Gets all available book categories.
     *
     * @return A list of all available book categories.
     */
    public List<String> getAllBookCategories() {
        BrowserUtils.waitFor(1);
        Select select = new Select(bookCategoriesDropdown);
        List<WebElement> listOfElements = select.getOptions();
        listOfElements.remove(0);
        return BrowserUtils.getElementsText(listOfElements);
    }

    /**
     * Selects a book category from the dropdown.
     *
     * @param category The category to select.
     */
    public void selectBookCategory(String category) {
        BrowserUtils.waitFor(1);
        Select select = new Select(bookCategoryDropdown);
        select.selectByVisibleText(category);
    }

    /**
     * Selects the number of records to show from the dropdown.
     *
     * @param recordNumberToShow The number of records to show.
     */
    public void selectRecordsToShow(String recordNumberToShow) {
        BrowserUtils.waitFor(1);
        Select select = new Select(showRecordsDropdown);
        select.selectByValue(recordNumberToShow);
    }

    /**
     * Enters text into the search box to search for a book.
     *
     * @param bookName The name of the book to search for.
     */
    public void searchBook(String bookName) {
        BrowserUtils.waitFor(1);
        searchBox.sendKeys(bookName);
    }

    /**
     * Enters the book name into the input box.
     *
     * @param bookName The name of the book to enter.
     */
    public void enterBookName(String bookName) {
        BrowserUtils.waitFor(1);
        bookNameInputBox.sendKeys(bookName);
    }

    /**
     * Enters the ISBN of the book into the input box.
     *
     * @param isbn The ISBN of the book to enter.
     */
    public void enterISBN(String isbn) {
        BrowserUtils.waitFor(1);
        isbnInputBox.sendKeys(isbn);
    }

    /**
     * Enters the published year of the book into the input box.
     *
     * @param publishedYear The published year of the book to enter.
     */
    public void enterPublishedYear(String publishedYear) {
        BrowserUtils.waitFor(1);
        publishedYearInputBox.sendKeys(publishedYear);
    }

    /**
     * Enters the author name of the book into the input box.
     *
     * @param authorName The author name of the book to enter.
     */
    public void enterAuthorName(String authorName) {
        BrowserUtils.waitFor(1);
        authorNameInputBox.sendKeys(authorName);
    }

    /**
     * Enters the book description into the text area.
     *
     * @param description The description of the book to enter.
     */
    public void enterDescription(String description) {
        BrowserUtils.waitFor(1);
        bookDescriptionTextArea.sendKeys(description);
    }

    /**
     * Gets the text of the message displayed on the page.
     *
     * @return The text of the message.
     */
    public String getMessageText() {
        BrowserUtils.waitFor(1);
        return toastMessage.getText();
    }

    /**
     * Gets the name of the book.
     *
     * @return The name of the book.
     */
    public String getBookName() {
        BrowserUtils.waitFor(1);
        return bookNameCell.getText();
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getISBN() {
        BrowserUtils.waitFor(1);
        return isbnCell.getText();
    }

    /**
     * Gets the published year of the book.
     *
     * @return The published year of the book.
     */
    public String getPublishedYear() {
        BrowserUtils.waitFor(1);
        return publishedYearCell.getText();
    }

    /**
     * Gets the author name of the book.
     *
     * @return The author name of the book.
     */
    public String getAuthorName() {
        BrowserUtils.waitFor(1);
        return authorNameCell.getText();
    }

    /**
     * Gets the category of the book.
     *
     * @return The category of the book.
     */
    public String getCategory() {
        BrowserUtils.waitFor(1);
        return categoryCell.getText();
    }

    /**
     * Gets the borrowed by information of the book.
     *
     * @return The borrowed by information of the book.
     */
    public String getBorrowedBy() {
        BrowserUtils.waitFor(1);
        return borrowedByCell.getText();
    }

    /**
     * Clears the book name input box.
     */
    public void deleteBookName() {
        BrowserUtils.waitFor(1);
        bookNameInputBox.clear();
    }

    /**
     * Clears the ISBN input box.
     */
    public void deleteISBN() {
        BrowserUtils.waitFor(1);
        isbnInputBox.clear();
    }

    /**
     * Clears the published year input box.
     */
    public void deletePublishedYear() {
        BrowserUtils.waitFor(1);
        publishedYearInputBox.clear();
    }

    /**
     * Clears the author name input box.
     */
    public void deleteAuthorName() {
        BrowserUtils.waitFor(1);
        authorNameInputBox.clear();
    }

    /**
     * Clears the description text area.
     */
    public void deleteDescription() {
        BrowserUtils.waitFor(1);
        bookDescriptionTextArea.clear();
    }
}
