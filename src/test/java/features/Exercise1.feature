Feature: Add address

 Scenario Outline:
    Given User on mystore-testlab.coderslab homepage
    Then User logs in on existing account "<login>""<passwd>"
    And User clicks addresses tab
    And User fills up the form with "<alias>""<address>""<city>""<postCode>""<country>""<phone>"
    Then Click save button
    And Confirm address text "<alias>""<address>""<city>""<postCode>""<country>""<phone>"

   Examples:
     | alias  | address | city    | postCode | country        | phone     | login                   | passwd    |
     | Tester | Glowna  | Gliwice | 44-100   | United Kingdom | 500500500 | testertestowy@tester.pl | passwd123 |