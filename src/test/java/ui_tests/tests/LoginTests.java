package ui_tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.pages.HomePage;

public class LoginTests extends BaseTest {

    @Test
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
