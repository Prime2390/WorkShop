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
@Story("Checking login function")
public class LoginTests extends BaseTest {


    @Test(description = "Check the system behavior after entering the correct email address and password.")
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
    @Test(description = "Check the system behavior when no data is entered.")
    @Description("The user does not enter login details")
    public void loginNoData() {
        HomePage homePage = new HomePage(driver);
        var loginOperation =  homePage.clickSingInButton()
                .clickLoginWithError();

        Assert.assertEquals(loginOperation.getEmailError(),"Email is required");
        Assert.assertEquals(loginOperation.getPasswordError(),"Password is required");





    }
}
