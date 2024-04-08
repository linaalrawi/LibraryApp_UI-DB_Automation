Feature: As a data consumer, I want UI and DB book categories are match.

  @ui @db @wip
  Scenario:Verify book categories with DB
    Given the user logged in as "librarian"
    When the user navigates to "Books" page
    And the user gets all book categories in webpage
    Then the user verifies that book categories match with book categories table from db