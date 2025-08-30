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
public class RegisterTests extends BaseTest {

    @Story("New user registration")
    @Test(description = "Registration with valid data")
    @Description("")
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
        System.out.println(operations.getCurrentURL());

        Assert.assertEquals(operations.getCurrentURL(),operations.getExpectedURL(), "Wrong URL");



    }


}
