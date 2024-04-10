Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui @db
  Scenario Outline:Verify added book is matching with DB
    Given the user logged in as "librarian"
    And the user navigates to "Books" page
    When the user clicks to add book
    And the user enters book name "<Book Name>"
    When the user enters ISBN "<ISBN>"
    And the user enters year "<Year>"
    When the user enters author "<Author>"
    And the user chooses the book category "<Book Category>"
    And the user clicks to save changes
    Then the user verifies that "The book has been created." message is displayed
    And the user verifies that "<Book Name>" information matches with DB
    Examples:
      | Book Name              | ISBN          | Year | Author      | Book Category      |
      | Island Love            | 4234567891235 | 1959 | Emir Yazici | Romance            |
      | Monster In The Lake    | 4334567891236 | 1962 | Emir Yazici | Horror             |
      | 75 Reason To Be Single | 4434567891237 | 1967 | Emir Yazici | Short Story        |
      | The Voyager 2091       | 4534567891238 | 1971 | Emir Yazici | Science Fiction    |
      | No Money No Honey      | 4534567891239 | 1972 | Emir Yazici | Classic            |
      | Blackberry Sky         | 4634567891230 | 1974 | Emir Yazici | Drama              |
      | 8th Sense              | 4634567891231 | 1977 | Emir Yazici | Fantasy            |
      | Third Encounter        | 4634567891232 | 1983 | Emir Yazici | Historical Fiction |