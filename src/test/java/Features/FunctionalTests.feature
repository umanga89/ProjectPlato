Feature: Documentation Site Funtional Tests

  Scenario Outline: Verify side panel page navigation
    Given user is in landing page
    When user clicks on page "<Page>"
    Then user should be navigated to page and see "<PageTitle>" and "<PageUrl>" for "<Page>"
    Examples:
    |Page|PageTitle|PageUrl|
    |Introduction|Welcome to the Documentation|https://very-important.vercel.app/|
    |Didcomm     |DIDComm Messaging           |https://very-important.vercel.app/didcomm|
    |Self Sovereign Identity|Self-sovereign identity (SSI)|https://very-important.vercel.app/self%20sovereign%20identity|


    Scenario: Search and view a page
      Given user is in landing page
      When user search for "DidComm" page and select it
      Then user is able to navigate to the page