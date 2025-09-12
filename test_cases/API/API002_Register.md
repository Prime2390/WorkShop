# API002 – Check registration function

## TC001 – Check system behavior with valid registration data
### Preconditions


### Test Data
| Key           | Value             | Notes               |
|---------------|-------------------|---------------------|
| First name    | Dominik           | valid first name    |
| Last name     | Bernaś            | valid last name     |
| Data of birth | 2000-07-03        | valid data of birtg |
| Street        | Powstańców        | valid street        |
| Postal code   | 42-400            | valid postal code   |
| City          | Warszawa          | valid city          |
| State         | Śląsk             | valid state         |
| Country       | Poland            | valid country       |
| Phone         | 504242241         | valid phone         |
| Email address | dominik@gmail.com | valid email address |
| Password      | Polskagurom12     | valid password      |

### Steps
1. Perform `POST /users/register` with the correct data


### Expected
- Returns status code 201
- Response body contains created user `ID`

-------

## TC002 – Check registration with existing email
### Preconditions
- User with email `dominik@gmail.com` already exists

### Test Data
| Key           | Value             | Notes               |
|---------------|-------------------|---------------------|
| First name    | Dominik           | valid first name    |
| Last name     | Bernaś            | valid last name     |
| Data of birth | 2000-07-03        | valid data of birtg |
| Street        | Powstańców        | valid street        |
| Postal code   | 42-400            | valid postal code   |
| City          | Warszawa          | valid city          |
| State         | Śląsk             | valid state         |
| Country       | Poland            | valid country       |
| Phone         | 504242241         | valid phone         |
| Email address | dominik@gmail.com | valid email address |
| Password      | Polskagurom12     | valid password      |

### Steps
1. Perform `POST /users/register` with the above data

### Expected
- Returns status code **422**
- Response contains error message: `"Email already in use"`


---


## TC003 – Check registration with invalid email format
### Preconditions
- None

### Test Data
| Key           | Value            | Notes               |
|---------------|------------------|---------------------|
| First name    | Dominik          | valid first name    |
| Last name     | Bernaś           | valid last name     |
| Data of birth | 2000-07-03       | valid data of birtg |
| Street        | Powstańców       | valid street        |
| Postal code   | 42-400           | valid postal code   |
| City          | Warszawa         | valid city          |
| State         | Śląsk            | valid state         |
| Country       | Poland           | valid country       |
| Phone         | 504242241        | valid phone         |
| Email address | dominik@gmailcom | valid email address |
| Password      | Polskagurom12    | valid password      |

### Steps
1. Perform `POST /users/register` with invalid email format

### Expected
- Returns status code **400**
- Response contains validation message: `"Invalid email format"`

