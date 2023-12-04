Feature: Products
  As user I want to select department and add product to cart

  Scenario: user should able to select department and able to add product to cart
    Given I am on homepage
    When  I select product department Computers
    And I click on sub department Notebooks
    Then I should navigate to department page successfully

    And I click on product "Asus N551JK-XO076H Laptop"
    Then I should navigate to selected product successfully
    And I click on Add product to cart button
    Then verify message product is added to cart "The product has been added to your shopping cart"

    And I click on shopping cart
    Then I should navigate to shopping cart page successfully
    And I select check box of terms of services
    And I click on checkout button
    Then I should navigate to login page

    And I enter an email
    And I enter password
    And I click on login button

    And I select check box of terms of services
    And I click on checkout button
    Then I should navigate to Checkout page

    And I select country "United Kingdom"
    And I enter city "London"
    And I enter an address "6 park road"
    And I enter postal code "NW101PT"
    And I enter phone number "07542187334"
    And Click on continue button
    And Click on shipping continue button
    And Select payment method by Check / Money order
    And Click on payment continue button
    Then Check payment information

    And Click on payment information continue button
    Then Check billing address and shipping address
    And Click on confirm order continue button
    Then I should navigate to order completed page

    Then I should see message "Your order has been successfully processed!"
    And I click on click here for order details link
    Then I should navigate to order information page



