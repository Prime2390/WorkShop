package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SingInPage extends BasePage {
    public SingInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement passowrd;
    @FindBy(xpath = "/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")
    private WebElement loginButton;

    public SingInPage enterEmail() {
        Allure.step("Enter email");
        type(email, PropertyReader.get("email"));
        return this;
    }
    public SingInPage enterPassword() {
        Allure.step("Enter password");
        type(passowrd, PropertyReader.get("password"));
        return this;
    }
    public Dashboard clickLoginButton() {
        Allure.step("Click 'login' button");
        this.loginButton.click();
        return new Dashboard(driver);
    }

}
