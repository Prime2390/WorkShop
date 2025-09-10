# TS003 - Checking the logout function
## TC001 – Checking logout
### Preconditions
- User has an account
### Test Data
| Key          | Value                                | Notes             |
|--------------|--------------------------------------|-------------------|
| email        | admin@practicesoftwaretesting.com    | valid admin email |
| password     | welcome01                            | valid password    |

### Steps
1. Open Homepage
2. Click "***Sign in***" button
3. Enter email "***admin@practicesoftwaretesting.com***"
4. Enter password "***welcome01***"
5. Click "***Login***" button
6. Click on "***John Doe***" at the top of the page
7. Click "***Sing out***"
### Expected
- Redirect to `/login`
- You see the login window

------
