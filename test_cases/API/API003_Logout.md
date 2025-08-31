# API003 – Valid log out


## Preconditions
- User has an account


## Steps
1. Perform `POST /users/login` with the correct data
2. Extract the access token from the response
3. Perform `GET /users/logout` using an access token

### Expected
- Returns status code 200
- The response contains the message ‘Successfully logged out’.
