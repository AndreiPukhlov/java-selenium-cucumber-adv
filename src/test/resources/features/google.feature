@google
Feature: All tests for Google page

  @google1
  Scenario: User search for cucumber selenium
	Given user is on the google page
	When they search for "Cucumber selenium"
	And they proceed with the result
	Then the right page is opened
	And they accepted cookies
	And the information about WebDriver printed to the console

  @google2
  Scenario: User search Google maps for a place
	Given user is on the google page
	When they navigates to the Google maps
	And they search maps for "Googleplex"
	Then search result for "Googleplex" is displayed




