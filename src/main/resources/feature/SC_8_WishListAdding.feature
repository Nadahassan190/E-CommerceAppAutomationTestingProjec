@smoke

Feature:F08_user could add products to wishlist


  Scenario:success message is visible after adding product to wishlist
    When user add product to wishlist
    Then wishlist notification success is visible


  Scenario:added product is displayed in wishlist page
    When user add product to wishlist again
    Then wishlist notification success is visible
    And  user go to wishlist page
    Then number of quantity is greater than zero in wishlist page
