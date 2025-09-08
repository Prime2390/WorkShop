# API004 – Forgot Password 


## Preconditions
- User has an account

## Test Data
| Key          | Value             | Notes             |
|--------------|-------------------|-------------------|
| email        | dominik@gmail.com | valid admin email |


## Steps
1. Perform `POST /users/forgot-password` with the correct email

### Expected
- Returns status code 200
- The response contains “success”.
