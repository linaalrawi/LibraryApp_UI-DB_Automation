Feature: Book Category

  @ui @wip
  Scenario: verify book categories with UI
    Given the user logged in as "librarian"
    When the user navigates to "Books" page
    And the user gets all book categories in webpage
    Then the user should be able to see following categories
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

  @ui @db @wip
  Scenario: verify book categories with DB
    Given the user logged in as "librarian"
    When the user navigates to "Books" page
    And the user gets all book categories in webpage
    Then the user verifies that book categories match with book categories table from db

  @ui @db @wip
  Scenario: Verify book information with db
    Given the user logged in as "librarian"
    And the user navigates to "Books" page
    When the user searches for "Agile Testing" book
    Then the user verifies that book information matches with database for "Agile Testing"