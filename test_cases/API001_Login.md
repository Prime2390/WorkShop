# API001 – Valid login


## Preconditions
- User has an account

## Test Data 
| Key          | Value                                | Notes             |
|--------------|--------------------------------------|-------------------|
| email        | admin@practicesoftwaretesting.com    | valid admin email |
| password     | welcome01                            | valid password    |

## Steps
1. Perform `POST /users/login` with the correct data

### Expected
- Returns status code 200
- The response contains “/access_token”.
