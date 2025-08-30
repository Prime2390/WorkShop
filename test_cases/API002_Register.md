# API002 – Valid registration


## Preconditions


## Test Data
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

## Steps
1. Perform `POST /users/register` with the correct data



### Expected
- Returns status code 201
- ID has been created.
