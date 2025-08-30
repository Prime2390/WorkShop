package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
    private WebElement singInButton;
    public String getURL = "http://localhost:4200/admin/dashboard";

    public LoginPage clickSingInButton() {
        Allure.step("Click 'sing in' button");
        click(singInButton);
        return new LoginPage(driver);
    }

}
