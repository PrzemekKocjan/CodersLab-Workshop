Feature: Buy Sweater

  Scenario Outline:
    Given User on mystore-testlab.coderslab homePage
    Then User logs in with existing account "<login>""<passwd>"
    Then User types Hummingbird Printed Sweater in searchfield
    And User clicks Hummingbird Printed Sweater floating tile
    Then User sets up the order
    Then User confirms address "<alias>""<address>""<city>""<postCode>""<country>""<phone>"
    Then User proceed with order completion


    Examples:
      | login                   | passwd    | alias  | address | city    | postCode | country        | phone     |
      | testertestowy@tester.pl | passwd123 | Tester | Glowna  | Gliwice | 44-100   | United Kingdom | 500500500 |