package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BasePage{

    public Dashboard(WebDriver driver) {
        super(driver);
        waitUntileExpected(getExpectedURL);
        PageFactory.initElements(driver, this);
    }
    public String getExpectedURL = "http://localhost:4200/admin/dashboard";

    @FindBy(id = "menu") private WebElement menu;
    @FindBy(css= "[data-test = 'nav-sign-out']") private WebElement signOut;
    @FindBy(css = "[data-test='nav-admin-products']") private WebElement adminProducts;

    public String getUserName() {
        return menu.getText();
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public Dashboard clickMenu() {
        Allure.step("Click Menu button");
        menu.click();
        return this;
    }
    public LoginPage clickSignOut() {
        Allure.step("Click 'Sign Out' button");
        click(signOut);
        return new  LoginPage(driver);
    }
    public ProductPage clickAdminProducts() {
        Allure.step("Click 'Product' button");
        click(menu);
        click(adminProducts);
        return new ProductPage(driver);
    }


}
