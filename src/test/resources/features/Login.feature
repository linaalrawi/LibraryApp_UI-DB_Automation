Feature: Login Functionality

  @ui @db
  Scenario: Login with valid credentials
    Given the user logged in "librarian11@library" and "donttrytochangethis"
    When the user gets username from user fields
    Then the user verifies that the username matches with database

  @ui @db
  Scenario Outline: Login with valid credentials <email>
    Given the user logged in "<email>" and "<password>"
    When the user gets username from user fields
    Then the user verifies that the username matches with database
    Examples:
      | email               | password    |
      | librarian21@library | libraryUser |
      | librarian23@library | libraryUser |
      | student16@library   | libraryUser |
      | student17@library   | libraryUser |