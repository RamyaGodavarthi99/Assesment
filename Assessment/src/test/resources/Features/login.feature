Feature: mercurytours Feature
@test
  Scenario Outline: Registeration Test Scenario
    Given user is already on landing Page
    When user clicks on registerlink
    Then user enters contact information "<firstname>" and "<lastname>" and "<phone>" and "<email>"
    Then user enters mailing address information "<address1>" and "<city>" and "<state>" and "<postalcode>"
    Then user enters user information "<username>" and "<password>" and "<confirmpassword>"
    Then user closes the browser

    Examples: 
      # @source:C:/Users/krishna/eclipse-workspace1/Cucumber/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx/Sheet1
      | firstname | lastname | phone      | email            | address1 | city | state | postalcode | username | password | confirmpassword |
      | krishna   | bandaru  | 9874564123 | kri124@gmail.com | 3-49     |  HYD  | TS    |      87541 | Test123  | test@123 | test@123        |
    #  | vijji     | VV       | 6421789964 | vvl123@gmail.com | 4-74    | MAS  | TN    |      78451 | Test231  | test@456 |                 |
