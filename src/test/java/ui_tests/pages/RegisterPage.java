package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ui_tests.models.FakerRegisterUser;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "first_name") private WebElement firstName;
    @FindBy(id = "last_name") private WebElement lastName;
    @FindBy(id = "dob") private WebElement dateOfBirth;
    @FindBy(id = "street") private WebElement street;
    @FindBy(id = "postal_code") private WebElement postcode;
    @FindBy(id = "city") private WebElement city;
    @FindBy(id = "state") private WebElement state;
    @FindBy(id = "country") private WebElement country;
    @FindBy(id = "phone") private WebElement phoneNumber;
    @FindBy(id = "email") private WebElement email;
    @FindBy(id = "password") private WebElement password;
    @FindBy(css = "[data-test='register-submit']") private WebElement registerButton;
   public FakerRegisterUser user = new FakerRegisterUser();

    public RegisterPage enterFirstName() {
        Allure.step("Enter first name");
      type(firstName, user.getFirstName());
      return this;
    }
    public RegisterPage enterLastName() {
        Allure.step("Enter last name");
        type(lastName, user.getLastName());
        return this;
    }
    public RegisterPage enterDateOfBirth() {
        Allure.step("Enter date of birth");
        type(dateOfBirth, user.getDateOfBirth());
        return this;
    }
    public RegisterPage enterStreet() {
        Allure.step("Enter street");
        type(street, user.getStreet());
        return this;
    }
    public RegisterPage enterPostcode() {
        Allure.step("Enter postcode");
        type(postcode, user.getPostalCode());
        return this;
    }
    public RegisterPage enterCity() {
        Allure.step("Enter city");
        type(city, user.getCity());
        return this;
    }
    public RegisterPage enterState() {
        Allure.step("Enter state");
        type(state, user.getState());
        return this;
    }
    public RegisterPage enterCountry() {
        Allure.step("Enter country");
        Select select = new Select(country);
        select.selectByValue(user.getCountry());
        return this;
    }
    public RegisterPage enterPhoneNumber() {
        Allure.step("Enter phone number");
        type(phoneNumber, user.getPhoneNumber());
        return this;
    }
    public RegisterPage enterEmail() {
        Allure.step("Enter email");
        type(email, user.getEmail());
        return this;
    }
    public RegisterPage enterPassword() {
        Allure.step("Enter password");
        type(password, user.getpassword());
        return this;
    }
    public LoginPage clickRegisterButton() {
        Allure.step("Click register button");
        registerButton.click();
        return new LoginPage(driver);
    }
}
