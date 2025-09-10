# SC001 - Checking login function


## TC001 – Check the system behavior after entering the correct email address and password.

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

#### Expected
- Redirect to `/dashboard`
- Username visible in header

------------

## TC002 – Check the system behavior when no data is entered.

### Preconditions 
#### Test Data


### Steps
1. Open Homepage
2. Click "***Sign in***" button
3. Click "***Login***" button

### Expected
- The error ‘Email is required’ is displayed.
- The error ‘Password is required’ is displayed.
