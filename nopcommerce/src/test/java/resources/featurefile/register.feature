Feature: Register Test
  As user I want to register into nop commerce website

  Scenario: User should create an account successfully
    Given I am on homepage
    When I click on register link
    And I enter following users details firstname,lastname, email, password, confirmPassword
    And I click on register button
    Then Verify message "Your registration completed"
