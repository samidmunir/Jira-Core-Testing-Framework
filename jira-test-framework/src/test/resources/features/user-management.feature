Feature: User Management

  @ui @user-management @smoke
  Scenario: Admin can navigate to User Management
    Given the admin is on the login page
    When the admin logs in with valid credentials
    And the admin navigates to User Management
    And the admin re-authenticates with the admin password
    Then the User Management page should be displayed