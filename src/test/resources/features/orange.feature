@orange
  Feature: All tests for Orange web site

	@orange1
	Scenario: User able to login with admin credentials
	  Given user is on the OrangeHRM home page
	  When they with provided user name and password for admin account
	  Then they logged in to the account
