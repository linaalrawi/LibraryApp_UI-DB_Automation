Feature: As a data consumer, I want to know genre of books are being borrowed the most

  @db @wip
  Scenario:Verify the the common book genre that’s being borrowed
    When the user executes query to find most popular book genre
    Then the user verifies "Fantasy" is the most popular book genre.