Feature: Login test
  As user I want to login into nopcommerce website

  Scenario: User should navigate to login page successfully and login with with valid credentials
    Given I am on homepage
    When I click on login link
    And I am on login page
    Then I should navigate to login page successfully
    And I enter an email
    And I enter password
    And I click on login button
    Then I should login successfully

  Scenario: User should not login with invalid credentials
    Given I am on homepage
    When I click on login link
    Then I should navigate to login page successfully
    When I enter an email" "
    And I enter password " "
    And I click on login button
    Then I should login successfully
