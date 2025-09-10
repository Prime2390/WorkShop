package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test = 'email']") private WebElement email;
    @FindBy(css ="[data-test = 'forgot-password-submit']") private WebElement submitButton;
    @FindBy(css = "div[role='alert'].alert.alert-success.mt-3") private WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"email-error\"]") private WebElement withoutEmailAlert;
    @FindBy(css = "div[role='alert'].alert.alert-danger.mt-3") private WebElement invalidEmailAlert;

    public ForgotPasswordPage enterEmail(String text) {
        Allure.step("Enter email");
        type(email, text);
        return this;
    }
    public ForgotPasswordPage clickSubmitButton() {
        Allure.step("Click submit button");
        click(submitButton);
        return this;
    }
    public String getSuccessMessage() {
        waitForVisibility(successMessage);
        return successMessage.getText();
    }
    public String getErrorMessagewithoutEmailAlert() {
        waitForVisibility(withoutEmailAlert);
        return withoutEmailAlert.getText();
    }
    public String getInvalidEmailAlert() {
        waitForVisibility(invalidEmailAlert);
        return invalidEmailAlert.getText();
    }

}
