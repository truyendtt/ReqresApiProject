@CreateUser
Feature: Check Create User Susscessfully

  @Maincase
  Scenario: Check Create User Susscessfully
    Given I have Url and method and requestBody
      | Url                         | method | requestBodyName            |
      | https://reqres.in/api/users | POST   | CreateUserRequestBody.json |
    When send request
    Then The reponse returns status "<statuscode>" and responsebody "<job>" and "<name>"
      | statuscode | job    | name     |
      |        200 | leader | morpheus |
