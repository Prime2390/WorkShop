# API003 – Checking logout function (API)

## TC001 – Check system behavior with valid token
### Preconditions
- User has a valid account
- User is logged in and has a valid `access_token`

### Test Data
| Key      | Value                                   | Notes               |
|----------|-----------------------------------------|-------------------- |
| Authorization    | Bearer <valid_token>       | valid access token    |  


### Steps
1. Perform `POST /users/login` with the correct data
2. Extract the access token from the response
3. Perform `GET /users/logout` using an access token

#### Expected
- Returns status code 200
- The response contains the message ‘Successfully logged out’.

-------

## TC003 – Check system behavior without token
### Preconditions
- User is not logged in or no token is provided

### Test Data  
| Key          | Value | Notes |
|--------------|-------|-------|
| Authorization|       | empty |

### Steps
1. Perform `POST /users/logout` without Authorization header

### Expected
- Returns status code **401**
- Response contains message: `"Unauthorized"`

--------

## TC003 – Check system behavior after logout (token reuse)
### Preconditions
- User is logged in and has a valid `access_token`
- User has performed logout successfully

### Test Data 
| Key          | Value                | Notes             |
|--------------|----------------------|-------------------|
| Authorization| Bearer <valid_token> | token used before |

### Steps
1. Perform `POST /users/login` with the correct data
2. Extract the access token from the response
3. Perform `GET /users/logout` using an access token
4. Perform `GET /users/logout` using an access token

### Expected
- Returns status code **401**
- Response contains error: `"Unauthorized` 