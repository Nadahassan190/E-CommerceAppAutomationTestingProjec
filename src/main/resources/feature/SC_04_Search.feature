@smoke
Feature:F04 User could search for any product

  Scenario Outline:1 user could search using product name

    When user clicks in search filed
    And  user Type product name as "<productname>"
    Then user find relevant products
    Examples:
    |productname|
    |book|
    |laptop|
    |nike|



  Scenario Outline: 2 user could search for product using sku

    When user clicks in search filed
    And  user Type product sku as "<sku>"
    Then "<sku>" shown in result page
      Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|