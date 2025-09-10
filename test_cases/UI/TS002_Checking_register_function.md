# SC002 -Checking the registration function
## TC001 – Checking the system behaviour after entering correct data
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
1. Open Homepage
2. Click "***Sign in***" button
3. Click "***Register your account***"
4. Enter First name "Dominik"
5. Enter Last name "Bernaś"
6. Enter Date of birth "2000.07.03"
7. Enter Street "Powstańców"
8. Enter Post code "42-400"
9. Enter City "Warszawa"
10. Enter State "Śląsk"
11. Select Country "Polska"
12. Enter Phone number "504242241"
13. Enter Email address "dominik@gmail.com"
14. Enter Password "Welcome12!"


### Expected
- Redirect to `/login`
- The user sees the login panel
