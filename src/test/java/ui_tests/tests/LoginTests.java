package ui_tests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.pages.HomePage;

@Epic("UI")
@Feature("Authorization and Registration")
public class LoginTests extends BaseTest {



    @Story("Login into application")
    @Test(description = "Login with valid data")
    @Description("The user is using the correct email address and password to log in.")
    public void login() {
        HomePage homePage = new HomePage(driver);

        var loginOperation =  homePage.clickSingInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginButton();

        String currentUrl = loginOperation.getCurrentURL();
        String expectedURL = loginOperation.getExpectedURL;
        String userName = loginOperation.getUserName();

        Assert.assertEquals(currentUrl, expectedURL, "Current URL is incorrect");
        Assert.assertEquals(userName, "John Doe", "User name is incorrect");

    }
}
