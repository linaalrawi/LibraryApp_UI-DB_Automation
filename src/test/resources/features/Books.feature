Feature: Book Category

  @ui
  Scenario: verify book categories with UI
    Given the user logged in as "librarian"
    When the user navigates to "Books" page
    And the user gets all book categories in webpage
    Then user should be able to see following categories
      | Action and Adventure    |
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |
  @ui @db
  Scenario: verify book categories with DB
    Given the user logged in as "librarian"
    When the user navigates to "Books" page
    And the user gets all book categories in webpage
    Then verify book categories must match book categories table from db
  @ui @db
  Scenario: Verify book information with db
    Given the user logged in as "librarian"
    And the user navigates to "Books" page
    When I open book "Agile Testing"
    Then book information must match the database for "Agile Testing"