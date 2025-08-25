package ui_tests.pages;

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

    public String getUserName() {
        return menu.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
