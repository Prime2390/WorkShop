# TS004 - Checking the password recovery function
## TC001 – Verifying password reset for an existing account
### Preconditions
- User has account
### Test Data
| Key          | Value             | Notes       |
|--------------|-------------------|-------------|
| email        | dominik@gmail.com | valid email |

### Steps
1. Open Homepage
2. Click "***Sign in***" button
3. Click "***Forgot your Password?***" button
4. Enter in "***Your email***" "dominik@gmail.com"
5. Click "***Set New Password***" button

### Expected
- The message `/page.forgot-password.confirm` is displayed.

------

## TC002 – Verifying password reset for an not existing account
### Preconditions
### Test Data
| Key          | Value                         | Notes         |
|--------------|-------------------------------|---------------|
| email        | notexistingaccount@gmail.com  | invalid email |
### Steps
1. Navigate to http://localhost:4200/
2. Click "***Sign in***" button
3. Click "***Forgot your Password?***" button
4. Enter in "***Your email***" "notexistingaccount@gmail.com"
5. Click "***Set New Password***" button

### Expected
- The error `The selected email is invalid.` is displayed.

------

## TC003 – Verification of password reset without entering an e-mail address
### Preconditions
### Test Data
### Steps
1. Navigate to http://localhost:4200/
2. Click "***Sign in***" button
3. Click "***Forgot your Password?***" button
4. Click "***Set New Password***" button

### Expected
- The error `Email is required` is displayed.