Feature: Add a book into the basket
  As a customer,
  I want to add a book into the basket
  so that I can buy it later if i still want it

  @navigateToAmazon @test
  Scenario: Navigate to amazon
    Given the user opens a web browser
    When the user opens amazon
    Then Amazon Home Page is visible

  @searchForBook @test
  Scenario Outline: Search for Harry potter book
    Given the user is on Amazon Home Page
    When the user enters "Harry Potter and the Cursed Child" into the Amazon Search Bar and presses enter
    And first result is "Harry Potter and the Cursed Child - Parts One and Two"
    And the item has badge "<Badge>"
    And the item type should be "<Format>"
    Then the item price should be "<Price>"

    Examples:
    | Badge              | Format        | Price|
    | Best Seller        | Kindle        | 0.00 |
    | Best Seller        | Hardcover     | 14.78 |
    | Best Seller        | Paperback     | 4.00 |


  @bookDetails @test
  Scenario: Navigate to book details
    Given the user is on Amazon Home Page
    When the user enters "Harry Potter and the Cursed Child" into the Amazon Search Bar and presses enter
    And the user click on title
    And title should be "Harry Potter and the Cursed Child - Parts One and Two"
    And badge should be "Best Seller"
    And price should be "4.00"
    And type should be "Paperback"
    And click add to basket button
    Then the user is redirected to Basket details


  @basketDetails @test
  Scenario: Book is added to the basket
    Given the user is on Basket details
    When notification is shown
    And title of the notification is "Added to basket"
    Then there is one item in the basket

  @editBasket @test
  Scenario: Edit basket
    Given the user is on Basket details
    When the user click on add to basket button
    And the user is redirected to "Shopping basket"
    And the item in the basket has title "Harry Potter and the Cursed Child - Parts One and Two"
    And badge should be "Best Seller"
    And type is "Paperback"
    And quantity is "1"
    Then Price should be "4.00"
