Feature: Homepage and Productpage

  Scenario: User visits home page, navigates to products and views products
    Given User opens browser and visits aspirations homepage
    When User clicks on Spend & Save
    Then The two products aspiration and aspiration plus is seen
    When User clicks on Get Aspiration
    Then User can input email
    When User exits the popup by clicking on the top right X
    Then The products page can be seen
    When User clicks on Get Aspiration Plus
    Then The yearly and monthly plan can be seen
