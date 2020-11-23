#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing Selenium and Cucumber Setup
  You will use this to test out various scenarios and features of Selenium

  @tag1
  Scenario: Title of your scenario
    Given Open Chrome and navigate to a site
    When Scrolls down the page and clicks on the link at the bottom
    Then Enters the form information
      |fName|lName|userEmail|
      |Janie|Smith|test1@test1.com|
      |Jimmie|Smith2|test2@test2.com|
      |Joey|Smith3|test3@test3.com|
      |Hazel|Smith4|test4@test4.com|