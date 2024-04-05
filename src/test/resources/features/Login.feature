Feature: Login Functionality

  @db
  Scenario: Login with valid credentials
    Given the user logged in  "librarian12@library" and "libraryUser"
    When user gets username  from user fields
    Then the username should be same with database

  @db
  Scenario Outline: Login with valid credentials <email>
    Given the user logged in  "<email>" and "<password>"
    When user gets username  from user fields
    Then the username should be same with database
    Examples:
      | email               | password    |
      | librarian12@library | libraryUser |
      | librarian23@library | libraryUser |
      | student14@library   | libraryUser |
      | student31@library   | libraryUser |