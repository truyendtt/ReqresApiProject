@CreateUser
Feature: Create User Successfully
  I want to use this template for my feature file

  @MainCase
  Scenario: Create User Successfully
    Given have Url and method and RequestBodyName
      | Url                | method | RequestBodyName           |
      | https://reqres.in/ | POST   | CreateUserRequestBody |
    When send request
    Then request response return "<statuscode>" and responsebody "<job>""<job>"
      | statuscode | job    | name     |
      |        200 | leader | morpheus |


