@yahoo
Feature: All tests for Yahoo page

  @bug
  @yahoo1
  Scenario: User can find a location by zip code to see weather forecast
	Given user is on the Yahoo page
	When they navigates to the Yahoo services
	And they chooses Weather
	And they chooses to find location by "94089" and chooses "Sunnyvale" from the search result
	Then they see weather forecast city name, country name, and the temperature
