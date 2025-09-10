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
@Story("Checking the registration function")
public class RegisterTests extends BaseTest {


    @Test(description = "Checking the system behaviour after entering correct data")
    @Description("The user registers using correct data.")
    public void registrationWithValidData() {
        HomePage homePage = new HomePage(driver);
        var operations = homePage.clickSingInButton()
                .clickSignInButton()
                .enterFirstName()
                .enterLastName()
                .enterDateOfBirth()
                .enterStreet()
                .enterPostcode()
                .enterCity()
                .enterState()
                .enterCountry()
                .enterPhoneNumber()
                .enterEmail()
                .enterPassword()
                .clickRegisterButton();


        Assert.assertEquals(operations.getCurrentURL(),operations.getExpectedURL(), "Wrong URL");



    }


}
