# TC001 – Valid login


## Preconditions
- User has an account

## Test Data 
| Key          | Value                                | Notes             |
|--------------|--------------------------------------|-------------------|
| email        | admin@practicesoftwaretesting.com    | valid admin email |
| password     | welcome01                            | valid password    |

## Steps
1. Open Homepage
2. Click "***Sign in***" button
3. Enter email "***admin@practicesoftwaretesting.com***"
4. Enter password "***welcome01***"
5. Click "***Login***" button

### Expected
- Redirect to `/dashboard`
- Username visible in header
