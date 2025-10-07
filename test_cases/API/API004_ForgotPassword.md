# API004 – Check forgot password function

## TC001 - Check system behavior where user has account 

### Preconditions
- User has an account

### Test Data
| Key          | Value             | Notes             |
|--------------|-------------------|-------------------|
| email        | dominik@gmail.com | valid admin email |


### Steps
1. Perform `POST /users/forgot-password` with the correct email

### Expected
- Returns status code 200
- The response contains “success”.

-------

## TC002 - Check system behavior where email is incorect

### Preconditon 
### Test Data
| Key          | Value            | Notes             |
|--------------|------------------|-------------------|
| email        | dominik@gmailcom | valid admin email |
