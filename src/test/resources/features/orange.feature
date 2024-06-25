@orange
  Feature: All tests for Orange web site

	@orange1
	Scenario: User able to login with admin credentials
	  Given user is on the OrangeHRM home page
	  When they attempt tp login with provided user name and password for admin account
	  Then they landed on the Dashboard page as logged in admin
