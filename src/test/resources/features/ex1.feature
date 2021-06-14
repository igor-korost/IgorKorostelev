Feature: Different control elements test

  Scenario: I open Different Elements Page Test and select checkboxes, radio button and element
    from dropdown menu and then I see logs for them.
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header
    And I open Different Elements Page
    When I select 'Water' and 'Wind' checkboxes
    And I select radio button 'Selen'
    And I select 'Yellow' from the dropdown menu
    Then Logs for every selected element will be displayed