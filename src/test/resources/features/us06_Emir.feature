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
      | Book Name                   | ISBN          | Year | Author      | Book Category      |
      | Singing Birds In The Forest | 5234567891235 | 1949 | Emir Yazici | Romance            |
      | Unknown Call                | 5334567891236 | 1952 | Emir Yazici | Horror             |
      | 66 Reason To Be Single      | 5434567891237 | 1957 | Emir Yazici | Short Story        |
      | The Voyager 3091            | 5534567891238 | 1961 | Emir Yazici | Science Fiction    |
      | Once Upon A Time In Hawaii  | 5534567891239 | 1962 | Emir Yazici | Classic            |
      | Black Friday Madness        | 5634567891230 | 1964 | Emir Yazici | Drama              |
      | 9th Sense                   | 5634567891231 | 1967 | Emir Yazici | Fantasy            |
      | Fourth Encounter            | 5634567891232 | 1973 | Emir Yazici | Historical Fiction |