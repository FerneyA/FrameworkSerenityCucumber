Feature: Login to SVP

  Scenario: Login with valid credentials

    Given User is on Home page SVP
    When User enters username as "55589143" and password as "QA2022"
    Then User should be able to login successfully