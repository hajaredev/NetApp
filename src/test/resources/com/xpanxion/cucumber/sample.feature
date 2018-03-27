Feature: Validate form filling

@test
Scenario: As a user I should be able to fill out a form with valid entries
        Given I am on the home page
        When I navigate to the automation practice form
        Then the form should be displayed
        When I enter "VALID_PERSONAL_INFORMATION" in the form
        Then I am on the automation practice form
