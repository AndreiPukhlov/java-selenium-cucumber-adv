@apple
  Feature: All tests for apple page

	@apple1
	Scenario: User can navigate to a product list page
	  Given user is on the apple page
	  When they navigates to the Mac section
	  And they chooses to explore all macs
	  And they chooses "iMac"
	  Then the "uMac" product page is displayed