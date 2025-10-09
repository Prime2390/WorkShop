package ui_tests.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.pages.HomePage;

public class AddNewProductTest extends BaseTest {
    @Epic("UI")
    @Feature("Operations on products")
    @Story("Add product")

    @Test(description = "Check the system behevior after correct add product")
    public void correctAddProduct() {
        HomePage homePage = new HomePage(driver);
     String actualAlert =  homePage.clickSingInButton()
                .enterEmail()
                .enterPassword()
                .clickLoginButton()
                .clickAdminProducts()
                 .addNewProduct()
                 .correctAddNewProduct()
                 .getAlertText();

        Assert.assertEquals(actualAlert, "Product saved!x");


    }


}
