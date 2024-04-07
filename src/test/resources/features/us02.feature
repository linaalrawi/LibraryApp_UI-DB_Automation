Feature: As a librarian, I want to know borrowed books number

  @ui @db
  Scenario:Verify the total amount of borrowed books
    Given the user logged in as "librarian"
    When the user gets borrowed books number
    Then the user verifies that the borrowed books number matches with DB