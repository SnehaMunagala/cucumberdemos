Feature: Calulator features

  Background: common step for all scenarios
    Given I have a calculator

  @single
  Scenario: Adding two Numbers
    Given I have a Calculator
    When I add 2 and 3
    Then I should get 5 as result

  @multiple
  Scenario Outline: Adding values mutliple times
    #Given I have a calculator
    When I add <one> and <two>
    Then I should get <total> as result
    #And I am happy

    Examples: 
      | one | two | total |
      |   3 |   5 |     8 |
      |   4 |   8 |    12 |
      |   8 |   2 |    10 |

  @operators
  Scenario Outline: performing multiple operations
    When I perform "<operator>" between <one> and <two>
    Then I should get <total> as result

    Examples: 
      | operator | one | two | total |
      | Add      |   4 |   8 |    12 |
      | -        |   7 |   3 |     4 |
      | *        |   6 |   6 |    36 |
      | /        |   8 |   4 |     2 |
