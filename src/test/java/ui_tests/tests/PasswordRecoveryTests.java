package ui_tests.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.pages.HomePage;

@Epic("UI")
@Feature("Authorization and Registration")
@Story("Checking password recovery function")
public class PasswordRecoveryTests extends BaseTest {
    @Test(description = "Verifying password reset for an existing account")
    @Description("The user recovers their password using the correct email address.")
    public void verifyPasswordReset() {
        HomePage homePage = new HomePage(driver);
        var loginOperation =  homePage.clickSingInButton()
                .clickForgetPasswordButton()
                .enterEmail("dominik@gmail.com")
                .clickSubmitButton()
                .getSuccessMessage();

        Assert.assertEquals(loginOperation,"page.forgot-password.confirm");
    }
    @Test(description = "Verifying password reset for an not existing account")
    @Description("The user recovers their password using the incorrect email address.")
    public void verifyPasswordResetWithIncorrectEmail() {
        HomePage homePage = new HomePage(driver);
        var loginOperation =  homePage.clickSingInButton()
                .clickForgetPasswordButton()
                .enterEmail("incorrectemail@gmail.com")
                .clickSubmitButton()
                .getInvalidEmailAlert();

        Assert.assertEquals(loginOperation,"The selected email is invalid. ");
    }
    @Test(description = "Verification of password reset without entering an e-mail address")
    @Description("The user recovers their password don't using email address.")
    public void verifyPasswordResetWithoutEmail() {
        HomePage homePage = new HomePage(driver);
        var loginOperation =  homePage.clickSingInButton()
                .clickForgetPasswordButton()
                .clickSubmitButton()
                .getErrorMessagewithoutEmailAlert();

        Assert.assertEquals(loginOperation,"Email is required");
    }




}
