Feature: User Management

  @ui @user-management @smoke
  Scenario: Admin can navigate to User Management
    Given the admin is on the login page
    When the admin logs in with valid credentials
    And the admin navigates to User Management
    And the admin re-authenticates with the admin password
    Then the User Management page should be displayed
  
  @ui @user-management @create-user
  Scenario: Admin can create a new user
    Given the admin is on the User Management page
    When the admin creates a new user
    Then the new user should appear in the user list

  @ui @user-management @deactivate-user
  Scenario: Admin can deactivate a user
    Given the admin is on the User Management page
    And a new user exists
    When the admin searches for the user by username
    And the admin opens the Edit User page for that user
    And the admin deactivates the user