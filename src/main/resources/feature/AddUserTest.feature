Feature: User Login
  I want to use this template for my feature file

  Scenario: Verify admin login successful
    Given user navigate to orange hrm URL
    When uses enters user name as "Admin" and password as "admin123" and click on login button
    Then user should be able to see "Welcome Shri Hector" message
    And user nevigate to admin page
    And user nevigate to add user page
    Then user add admin user with employ name as "Alice Duval",user name "Anthony234", passord is "Anthony@1231" and confirmation password is "Anthony@1231"
    