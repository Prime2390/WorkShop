package ui_tests.pages;

import org.apache.groovy.json.internal.Exceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
    private WebElement singInButton;
    public String getURL = "http://localhost:4200/admin/dashboard";

    public SingInPage clickSingInButton() {
        click(singInButton);
        return new SingInPage(driver);
    }

}
