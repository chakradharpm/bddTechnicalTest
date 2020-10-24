Feature:Register a new user to takealot.com, login and perform a product search to get price of the product


  Scenario: Register a new user to takealot.com website
    Given user is on the register page
    When the user fills in all the mandatory details
    And uncheck all the news letter options
    And uncheck all the special offer
    And click on the register now button to register

  Scenario: Login to the takealot.com
    Given user is on the takealot.com webpage
    When the user enters email address
    And the user enters password
    And click on the Login button
    Then the user should land on the home page with his name displayed on the navigation bar

  Scenario: Searching for a product
    Given the user is in the homepage
    When the user types GiGABYTE Solid state drive 120GB in the search bar
    And the user click on the search button

  Scenario: Verify the price of the searclhed product
    Given the user is on the product page
    Then the user should see the price of the product

