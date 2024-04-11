Feature: As a data consumer, I want UI and DB book information are match.

  @ui @db
  Scenario:Verify book information with DB
    Given the user logged in as "librarian"
    And the user navigates to "Books" page
    When the user searches for "The House of Mirth" book
    And  the user clicks edit book button by book name "The House of Mirth"
    Then the user verifies that book "The House of Mirth" information matches with Database