Feature: Testing a REST API
  Users should be able to submit GET, POST, PUT, DELETE requests to a web service

  Scenario: client makes call to GET /assignment/{id}
    When the client calls /assignment/1
    Then the client receives status code of 200
    And the client receives server the assignment with id 1

  Scenario: client makes call to POST /assignment/save
    Given assignment to be added
      | 1 | hey | 10/02/2018 |
    When the client calls /assignment/save
    Then the client receives status code of 200
    And the client receives server added assignment | 1 | hey | 10/02/2018|

  Scenario: client makes call to PUT /assignment/update/{id}
    Given assignment to be updated
      | 1 | hey cucumber | 11/02/2018 |
    When the client calls /assignment/update/1
    Then the client receives status code of 200
    And the client receives server updated assignment | 1 | hey cucumber | 11/02/2018 |

  Scenario: client makes call to POST /assignment/delete/{id}
    Given the client calls /assignment/delete/1
    Then the client receives status code of 200
    And the client receives server deleted status 1


#      |idAssignment | 1
#      |description | hey
#      |endDate | 10/02/2018