Feature: Add a book into the basket
  As a customer,
  I want to add a book into the basket
  so that I can buy it later if i still want it

  @navigateToAmazon
  Scenario: Navigate to amazon.co.uk
    Given the user opens a web browser
    When the user types amazon.co.uk
    Then Amazon Home Page is visible

  @searchForBook
  Scenario: Search for Harry potter book
    Given the user is on Amazon Home Page
    When the user enters "Harry Potter and the Cursed Child" into the amazon.search.bar
    And click enter
    And first result is "Harry Potter and the Cursed Child - Parts One & Two"
    And the item has badge "<Badge>"
    And Items type should be "<Price>"
    And Items price should be "<Format>"
    Then the uuser click on title
    Examples:
              | Badge              | Format        | Price                                             |
              | Best Seller        | Paperback     | 6.67 |
              | Best Seller        | Hardcover     | 14.78 |
              | Best Seller        | Hardcover     | 0.00 |

  @bookDetails
  Scenario: Navigate to book deteails
    Given the user is on Book Details page
    When title should be "Harry Potter and the Cursed Child - Pssarts One & Two"
    And Badge should be "Best Seller"
    And Price should be "6.67"
    And Type is "Paperback"
    And Click add.to.basket.button
    Then the user is redirected to Basket details


  @basketDetails
  Scenario: Book is addted to the basket
    Given the user is on Basket details
    When notification os shown
    And title of the notification is "Added to basket"
    Then there is one item in the basket

  @editBasket
  Scenario: Edit basket
    Given the user is on Basket details
    When the user click on add.to.basket.button
    And the user is redirected to "Shopping basket"
    And the item in the basket has title "Harry Potter and the Cursed Child - Parts One & Two"
    And badge should be "Best Seller"
    And type is "Paperback"
    And quantity is "1"
    Then Price should be "6.67"
