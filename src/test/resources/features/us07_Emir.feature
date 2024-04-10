Feature: Books module
  As a students, I should be able to borrow book

  @ui @db
  Scenario: Student borrow new book
    Given the user logged in as "student"
    And the user navigates to "Books" page
    And the user searches for "Four Night In Honolulu" book
    When the user clicks Borrow Book button by book name "Four Night In Honolulu"
    Then the user verifies that book "Four Night In Honolulu" is shown in "Borrowing Books" page
    And the user verifies that student has same book "Four Night In Honolulu" in database
    And the user return the book "Four Night In Honolulu"