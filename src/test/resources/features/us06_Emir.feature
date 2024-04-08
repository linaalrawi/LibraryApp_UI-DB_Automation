Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui @db @wip
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
    Then the user verifies that "The book has been created" message is displayed
    And the user verifies that "<Book Name>" information matches with DB
    Examples:
      | Book Name              | ISBN     | Year | Author      | Book Category   |
      | A Night In Honolulu    | 10123456 | 2002 | Emir Yazici | Romance         |
      | Last In Last Out       | 11123456 | 2008 | Emir Yazici | Horror          |
      | 10 Reason To Be Single | 12123456 | 2012 | Emir Yazici | Short Story     |
      | The Voyager 2089       | 13123456 | 2018 | Emir Yazici | Science Fiction |