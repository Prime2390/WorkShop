# SC005 Checking add product function

## TC001 - Check the system behevior after correct add product

### Precondition
- User is login on administrator account

### Test Data
| Key         | Value                             | Notes             |
|-------------|-----------------------------------|-------------------|
| email       | admin@practicesoftwaretesting.com | valid admin email |
| password    | welcome01                         | valid password    |
| Name        | Młoteczek                         | valid admin email |
| Description | Idealny do wbijania gwoździ       | valid password    |
| stock      | 50                                | valid admin email |
| price    | 10                                | valid password    |


### Steps
1. Navigate to http://localhost:4200/
2. Click "***Sign in***" button
3. Enter email "***admin@practicesoftwaretesting.com***"
4. Enter password "***welcome01***"
5. Click "***Login***" button
6. Click "John Doe" on header
7. Click "Products"
8. Click "Add Product"
9. Enter name "Młoteczek"
10. Enter description "Idealny do wbijania gwoździ"
11. Enter stock "50"
12. Enter price "10"
13. Chose brand "MightyCraft Hardware"  
14. Chose Category "Hammer"
15. Chose image "Claw Hammer"
16. Click "Save" button

#### Expected
- Informaction "Product save" is displayed
- New product is in Product page.
