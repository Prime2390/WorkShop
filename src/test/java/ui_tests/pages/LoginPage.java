package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyReader;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        waitUntileExpected(expectedURL);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement passowrd;
    @FindBy(xpath = "/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")
    private WebElement loginButton;
    @FindBy(xpath = "/html/body/app-root/div/app-login/div/div/div/div/p/a[1]") private WebElement signInButton;

   private final String expectedURL = "http://localhost:4200/auth/login";

    public String getExpectedURL() {
        return expectedURL;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public LoginPage enterEmail() {
        Allure.step("Enter email");
        type(email, PropertyReader.get("email"));
        return this;
    }
    public LoginPage enterPassword() {
        Allure.step("Enter password");
        type(passowrd, PropertyReader.get("password"));
        return this;
    }
    public Dashboard clickLoginButton() {
        Allure.step("Click 'login' button");
        this.loginButton.click();
        return new Dashboard(driver);
    }
    public RegisterPage clickSignInButton() {
        Allure.step("Click 'Register your account' button");
        click(signInButton);
        return new RegisterPage(driver);

    }

}
