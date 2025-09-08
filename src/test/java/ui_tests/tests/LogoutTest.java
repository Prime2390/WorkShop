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
public class LogoutTest extends BaseTest {

    @Story("Logging out of the application")
    @Test(description = "Administrator logout")
    @Description("The administrator logs out and returns to the login page.")
    public void logout() {
        HomePage homePage = new HomePage(driver);
        var loginOperation =  homePage.clickSingInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginButton()
                .clickMenu()
                .clickSignOut();

        String expectedURL = loginOperation.getExpectedURL();
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL, "Wrong URL");
        Assert.assertTrue(driver.getPageSource().contains("Login"), "Wrong Page Source");
    }



}
