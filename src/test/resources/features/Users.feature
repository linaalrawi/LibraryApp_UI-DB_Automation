Feature: User management

  @ui @db
  Scenario: Updating user status as librarian should change current user status in DB
    Given the user logged in as "librarian"
    And the user navigates to "Users" page
    When the user clicks Edit User button
    And the user changes user status "ACTIVE" to "INACTIVE"
    And the user clicks save changes button
    Then the user verifies that the "The user updated." message is displayed
    And the user verifies that status information matches with database
    And the user changes current user status "INACTIVE" to "ACTIVE"