Feature: Create and update a user in Todo.ly
  Scenario: create and update the user

    Given uso autentificacion none
    When uso request POSTH al enlace /api/user.json con el json
    """
    {
    "Email":"examenmanuel27@upb.com",
    "FullName":"Manuel Valenzuela",
    "Password":"prueba123"
    }
    """
    Then recivo una respuesta 200
    And verifico que el body de respuesta sea
    """
    {
    "Id": "IGNORE",
    "Email": "examenmanuel27@upb.com",
    "Password": null,
    "FullName": "Manuel Valenzuela",
    "TimeZone": 0,
    "IsProUser": false,
    "DefaultProjectId": "IGNORE",
    "AddItemMoreExpanded": false,
    "EditDueDateMoreExpanded": false,
    "ListSortType": 0,
    "FirstDayOfWeek": 0,
    "NewTaskDueDate": -1,
    "TimeZoneId": "Pacific Standard Time"
    }
    """
    When actualizo con el link /api/user.json con el usuario examenmanuel27@upb.com y password prueba123 con el json
    """
    {
      "FullName": "Manuel Valenzuela Update"
    }
    """
    Then recivo una respuesta 200    Then recivo una respuesta 200