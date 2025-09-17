Feature: Demo QA Elements Page Test
  Scenario: Demo QA elements
    Given I am on the Demo QA page "https://demoqa.com/"
    When I click on Elements tab
    Then I am navigated to page "https://demoqa.com/elements"
    When I click on Text Box link
    Then I can see Text Box fields
    When I enter "John Doe" in the Full Name field
