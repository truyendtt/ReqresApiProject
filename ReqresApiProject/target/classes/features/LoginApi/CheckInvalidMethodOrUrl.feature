@LoginApi
Feature: Check invalid method or Url

  #TC001,002
  Scenario Outline: Check invalid method
    Given I have "<Url>" and "<Method>"
    When I send the request
    Then I validate the outcomes "<StatusCode>" and "<ErrorMessage>"

    Examples: 
      | Url                               | Method | StatusCode | ErrorMessage   |
      | https://reqres.in/api/login       | GET    |        405 | Invalid Method |
   #   | https://reqres.in/apifdafds/login | POST   |        404 | Not Found      |
