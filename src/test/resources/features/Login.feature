Feature: Login Functionality

  @ui @db
  Scenario: Login with valid credentials
    Given the user logged in "ursulaschiller@library" and "libraryUser"
    When the user gets username from user fields
    Then the user verifies that the username matches with database

  @ui @db
  Scenario Outline: Login with valid credentials <email>
    Given the user logged in "<email>" and "<password>"
    When the user gets username from user fields
    Then the user verifies that the username matches with database
    Examples:
      | email                   | password    |
      | katiavandervort@library | libraryUser |
      | orencrona@library       | libraryUser |
      | erwingusikowski@library | libraryUser |
      | daniellspencer@library  | libraryUser |
      | collintorp@library      | libraryUser |
      | gemmamertz@library      | libraryUser |
      | andrewreilly@library    | libraryUser |
      | angelialebsack@library  | libraryUser |
      | scottiemckenzie@library | libraryUser |