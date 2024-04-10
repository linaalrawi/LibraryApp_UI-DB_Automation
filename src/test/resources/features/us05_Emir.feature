Feature: As a data consumer, I want to know genre of books are being borrowed the most

  @db
  Scenario:Verify the the common book genre that’s being borrowed
    When the user executes query to find most popular book genre
    Then the user verifies "Action and Adventure" is the most popular book genre.