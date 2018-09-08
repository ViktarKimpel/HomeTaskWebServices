Feature: GmailTest

  Background: Given I opened StartPage

  Scenario Outline: Log In Under account

  When I opened LogInPage
  And I entered <email>
  And I opened GmailPasswordPage
  And I entered <password>
  Then I opened GmailMainPage

   Examples:
     |email                       |password     |
     |viktarr.kimpell@gmail.com   |Imrahil12161 |


  Scenario Outline: 2. Log In Under account

    When I opened LogInPage
    And I entered <email>
    And I opened GmailPasswordPage
    And I entered <password>
    Then I opened GmailMainPage

    Examples:
      |email                       |password     |
      |viktarrr.kimpelll@gmail.com |Imrahil121611|