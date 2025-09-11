# WorkShop – Testing Suite 

##  Project Goal
The **WorkShop** project is designed to test the [Practice Software Testing](https://github.com/testsmith-io/practice-software-testing) application.  
It contains **manual testing**, **automated testing **, and **API testing**.  
The test application is hosted locally using **Docker**.

###  Main Objectives:
- Verify the correct functioning of key e-commerce features (login, registration, cart, checkout, admin panel).
- Automate regression tests to improve efficiency and repeatability.
- Document both manual and automated tests in separate directories.
- Cover API testing using Postman collections and Rest Assured .

---

##  System Requirements

###  Basic Requirements
- **Operating System**: Windows, macOS, or Linux
- **Java**: OpenJDK 17+
- **Maven**
- **Git**
- **Docker**
- **Postman**

###  Additional Requirements for Automated Tests
- **Google Chrome**
- **Selenium WebDriver**
- **TestNG**
- **Allure Reports**

---

##  Project Structure
<pre>
Workshop/
  ├── test_case          # Manual test scenarios
  ├── ui-tests           # Automated UI tests (Selenium + Java + POM)
  │── api-tests          # API testing (Postman collections + Rest Assured)
  │── .gitignore         # Ignored files
  ├── pom.xml            # Maven configuration
  ├──README.md           # Main documentation
</pre>

##  Running the Application and Tests
1. Download and build the test application
- git clone https://github.com/testsmith-io/practice-software-testing.git
- cd practice-software-testing
- docker compose up -d --build
2. Clone the test repository
- git clone https://github.com/Prime2390/WorkShop.git
- cd WorkShop
3. Run the tests
- mvn clean test
4. Generating Reports 
- mvn allure:serve

  <h2>Author</h2>
<p>Project developed by <strong>Dominik Bernas</strong>.</p>

