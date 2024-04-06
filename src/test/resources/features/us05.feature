Feature: As a data consumer, I want to know genre of books are being borrowed the most

  @db
  Scenario: verify the the common book genre that’s being borrowed
    When the user execute query to find most popular book genre
    Then verify "Fantasy" is the most popular book genre.