Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.

  @db
  Scenario:Verify that users have unique IDs
    When the user executes query to get all IDs from users
    Then the user verifies that all users have unique IDs

  @db
  Scenario:Verify users table columns
    When the user executes query to get all columns
    Then the user verifies the below columns are listed in result
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |