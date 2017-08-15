Feature: To validate Jenkins login

@login
Scenario: Login with valid credentials
Given user go to login page
And enter username and password
And click on login button
Then user should be logged in into jenkins