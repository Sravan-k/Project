Feature: Select value from dropdown

  Scenario: Perform value selction from dropdown
    # Pre-condition: ASNs with assigned shipments & in initiated status
    Given User is on the page with dropdown selection
    And click the "30" in the dropdown from "picker_1"
    Then verify the selectedValue