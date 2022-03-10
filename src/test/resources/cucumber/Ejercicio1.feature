Feature: Crear y actualizar un usuario en Todo.ly
  Scenario: crear y actualizar usuario

    Given uso autentificacion none
    When uso request POSTH al enlace /api/user.json con el json
    """
    {
    "Email":"examplemanuel29@upb.com",
    "FullName":"Manuel Valenzuela",
    "Password":"prueba123"
    }
    """
    Then recivo una respuesta 200
    And verifico que el body de respuesta sea
    """
     {
    "Id": "IGNORE",
    "Email": "examenmanuel29@upb.com",
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
    When actualizo con el link /api/user.json con el usuario examen examplemanuel29@upb.com y password prueba123 con el json
    """
    {
    "FullName":"Manuel Valenzuela Update"
    }
    """
    Then recivo una respuesta 200