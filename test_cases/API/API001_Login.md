# SC002 – Checking login function (API)

## TC001 – Check system behavior with valid email and password
### Preconditions
- User has a valid account

### Test Data  
| Key      | Value                                   | Notes              |
|----------|-----------------------------------------|--------------------|
| email    | admin@practicesoftwaretesting.com        | valid admin email  |
| password | welcome01                               | valid password     |

### Steps
1. Perform `POST /users/login` with the above data

### Expected
- Returns status code **200**
- Response contains `"access_token"`


## TC002 – Check system behavior with invalid password
### Preconditions
- User has a valid account

### Test Data  
| Key      | Value                                   | Notes             |
|----------|-----------------------------------------|-------------------|
| email    | admin@practicesoftwaretesting.com        | valid admin email |
| password | wrongPass123                            | invalid password  |

### Steps
1. Perform `POST /users/login` with the above data

### Expected
- Returns status code **401**
- Response contains error message: `"Unauthorized"`


## TC003 – Check system behavior with invalid email
### Preconditions
- User account does **not** exist with given email

### Test Data 
| Key      | Value                    | Notes            |
|----------|--------------------------|------------------|
| email    | fakeuser@test.com        | invalid email    |
| password | welcome01                | valid password   |

### Steps
1. Perform `POST /users/login` with the above data

### Expected
- Returns status code **401**
- Response contains error message: `"Unauthorized"`


## TC004 – Check system behavior with empty email and password
### Preconditions
- None

### Test Data
| Key      | Value | Notes |
|----------|-------|-------|
| email    |       | empty |
| password |       | empty |

### Steps
1. Perform `POST /users/login` with the above data

### Expected
- Returns status code **401**
- Response contains validation errors: `"Invalid login request"`


## TC005 – Check system behavior with SQL injection attempt
### Preconditions
- None

### Test Data 
| Key      | Value               | Notes           |
|----------|---------------------|-----------------|
| email    | `' OR '1'='1`       | SQL injection   |
| password | `' OR '1'='1`       | SQL injection   |

### Steps
1. Perform `POST /users/login` with the above data

### Expected
- Returns status code **401**
- Response contains safe error message: `"Unauthorized"`

