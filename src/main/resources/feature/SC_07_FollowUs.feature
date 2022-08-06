@smoke

Feature: F07_user could follow social media links

  Scenario: user opens facebook link
    When user opens facebook link
    Then facebook "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
    When user opens twitter link
    Then twitter "https://twitter.com/nopCommerce" is opened in new tab

  Scenario:user opens rss link
    When user opens rss link
    Then rss "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario:user opens youtube link
    When user opens youtube link
    Then youtube "https://www.youtube.com/user/nopCommerce" is opened in new tab