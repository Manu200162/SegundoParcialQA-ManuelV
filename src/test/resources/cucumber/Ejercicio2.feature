Feature: Create and update a user in Todo.ly
  Scenario: create and update the user

    Given uso autentificacion basic
    When uso request POST al enlace /api/projects.json con el json
    """
    {
    "Content":"ManuelVProject4",
    "Icon":4
    }
    """
    Then recivo una respuesta 200
    And verifico que el body de respuesta sea
    """
    {
        "Id": "IGNORE",
        "Content": "ManuelVProject4",
        "ItemsCount": 0,
        "Icon":4,
        "ItemType": "IGNORE",
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [
        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    And recivo el Id guardado en Id_project

    When uso request POST al enlace /api/items.json con el json
    """
    {
    "Content":"PrimerItem",
    "ProjectId": Id_project
    }
    """
    Then recivo una respuesta 200
    And verifico que el body de respuesta sea
    """
    {
        "Id": "IGNORE",
        "Content": "PrimerItem",
        "ItemType": "IGNORE",
        "Checked": false,
        "ProjectId": Id_project,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": "IGNORE",
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": "IGNORE"
    }
    """
    And recivo el Id guardado en Id_item

    When uso request PUT al enlace /api/items.json con el json
    """
    {
      "Checked":true
    }
    """
    Then recivo una respuesta 200

    When uso request DELETE al enlace /api/items/Id_item.json con el json
    """
    """
    Then recivo una respuesta 200
