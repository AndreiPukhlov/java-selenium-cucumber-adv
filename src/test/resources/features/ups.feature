# Doesn't work in headless mode
@ups
Feature: All tests for ups

  @ups1
  Scenario: User fills in shipment form
	Given user is on the shipment page
	When they fills all the required fields for the sender
	And they fills all the required fields for the recipient
	And they chooses UPS letter
	And they confirms residential address
	Then all provided information is saved correctly

  @being_developed
  @ups2
  Scenario: User can edit information filled during shipment creation