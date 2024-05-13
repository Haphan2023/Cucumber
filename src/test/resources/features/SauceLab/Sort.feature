Feature: Sort Feature

  Background:
    Given user login into system

  @SortZToA  @regression_test
  Scenario: Sort Name Z to A

    When user choose sort name Z to A
    Then products will be sorted by Z to A

  @SortAToZ
  Scenario: Sort Name A to Z

    When user choose sort name A to Z
    Then products will be sorted by A to Z

  @SortLowToHigh
  Scenario: Sort Price Low to High

    When user choose sort price Low to High
    Then products will be sorted by Low to High

  @SortHighToLow
  Scenario: Sort Price High to Low

    When user choose sort price High to Low
    Then products will be sorted by High to Low
