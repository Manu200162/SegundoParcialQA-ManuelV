Feature: Create and update a user in Todo.ly
  Scenario: create and update the user

    Given uso autentificacion basic
    When uso request GET al enlace /api/authentication/token.json con el json
    """

    """
    Then recivo una respuesta 200
    And recivo el TokenString guardado en TOKEN
    And verifico que el body de respuesta sea
    """
    {
      "TokenString": TOKEN,
      "UserEmail": "upb_api_prueba@upb.com",
      "ExpirationTime": "IGNORE"
    }
    """
    When envio un delete request con TOKEN a /api/authentication/token.json
    Then recivo una respuesta 200
    And verifico que el body de respuesta sea
    """
    {
      "TokenString": TOKEN,
      "UserEmail": "upb_api_prueba@upb.com",
      "ExpirationTime": "IGNORE"
    }
    """
