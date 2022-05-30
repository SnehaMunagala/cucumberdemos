Feature: Guru site login functionality

@UI
  Scenario: valid login to Guru website.
    Given I am registered user with following details
      |mngr410087|guru@123|
      #| userName   | password |
      #| mngr410087 | guru@123 |
    When I login with above credentials
    Then I should see my home page

 @NonUI
  Scenario: Adding two Numbers
    Given I have a Calculator
    When I add 2 and 3
    Then I should get 5 as result