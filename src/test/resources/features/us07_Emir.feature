Feature: Books module
  As a students, I should be able to borrow book

  @ui @db @wip
  Scenario: Student borrow new book
    Given the user logged in as "student"
    And the user navigates to "Books" page
    And the user searches for "Self Confidence" book
    When the user clicks Borrow Book
    Then the user verifies that book is shown in "Borrowing Books" page
    And the user verifies that student has same book in database