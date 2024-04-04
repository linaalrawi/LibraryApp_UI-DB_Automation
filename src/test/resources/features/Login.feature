Feature: Login Functionality

  @db
  Scenario: Login with valid credentials
    Given the user logged in  "librarian44@library" and "libraryUser"
    When user gets username  from user fields
    Then the username should be same with database

  @db
  Scenario Outline: Login with valid credentials <email>
    Given the user logged in  "<email>" and "<password>"
    When user gets username  from user fields
    Then the username should be same with database
    Examples:
      | email               | password |
      | librarian32@library | libraryUser |
      | librarian41@library | libraryUser |
      | student4@library    | libraryUser |
      | student3@library    | libraryUser |