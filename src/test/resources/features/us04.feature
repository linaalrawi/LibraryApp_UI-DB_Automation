Feature: As a data consumer, I want UI and DB book information are match.

  @ui @db @wip
  Scenario:Verify book information with DB
    Given the user logged in as "librarian"
    And the user navigates to "Books" page
    When the user searches for "Clean Code" book
    And  the user clicks edit book button
    Then the user verifies that book information matches with Database