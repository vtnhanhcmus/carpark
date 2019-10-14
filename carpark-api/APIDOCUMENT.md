## Document Api

- Api neaerest
    
    Request
    ```http
    GET /carparks/nearest?latitude=0.26692094338788896&longitude=0.34860216031147967&page=1&perPage=20
    ```
    | Parameter | Type | Description |
    | :--- | :--- | :--- |
    | `latitude` | `Double` | **Required**.|
    | `longitude` | `Double` | **Required**.|
    | `page` | `Integer` | |
    | `per_page` | `Integer` | |
    
    Responses

    ```javascript
    [
        {
            "address": "BLK 5 TO 8 MARINE TERRACE",
            "latitude": 0.28602422294694535,
            "longitude": 0.33484593429574255,
            "distance": 1.6264891735357274,
            "totalLots": 301,
            "availableLots": 261
        }
    ]
    ```     
- Api dummy

   Request
   
   ```http
   GET /api/migrate
   ```
   
   Responses
   
   ```
  {
         "result": true
  }
    ```      

## Status Codes

| Status Code | Description |
| :--- | :--- |
| 200 | `OK` |
| 201 | `CREATED` |
| 400 | `BAD REQUEST` |
| 404 | `NOT FOUND` |
| 500 | `INTERNAL SERVER ERROR` |

