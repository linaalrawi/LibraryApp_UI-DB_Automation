Feature: Dashboard Page

  @ui @db
  Scenario: Dashboard data verification
    Given the user logged in as "librarian"
    When the user gets all information from modules
    Then the user verifies that the information matches with database