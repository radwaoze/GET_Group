Feature: Choose Clothing Item
  I want to register in Training Registration Form


Scenario: Go through steps to register user in
  Given The user navigates to Registration form
  When User enters valid credentials in Registration form
  And User clicks Register CTA
  Then Registration confirmation message should be displayed
