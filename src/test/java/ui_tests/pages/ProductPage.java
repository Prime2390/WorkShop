package ui_tests.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-test='product-add']") private WebElement addProduct;
    @FindBy(css = "[data-test='product-search-query']") private WebElement searchProduct;
    @FindBy(css = "[data-test=\"product-search-submit\"]") private WebElement searchButton;
    @FindBy(css = "[data-test=\"product-search-reset\"]") private WebElement searchResetButton;


    public AddNewProductPage addNewProduct() {
        Allure.step("Add new product");
        click(addProduct);
    return new AddNewProductPage(driver);
    }

}
