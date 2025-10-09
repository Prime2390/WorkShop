package ui_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui_tests.models.Product;


public class AddNewProductPage extends BasePage {

    public AddNewProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name") private WebElement name;
    @FindBy(id ="description") private WebElement description;
    @FindBy(id ="stock") private WebElement stock;
    @FindBy(id = "price") private WebElement price;
    @FindBy(id = "brand_id") private WebElement brand;
    @FindBy(id = "category_id") private WebElement category;
    @FindBy(id = "product_image_id") private WebElement image;
    @FindBy(css = "[data-test=\"product-submit\"]") private WebElement submit;
    @FindBy(css =".alert-success") private WebElement alert;

    public AddNewProductPage correctAddNewProduct() {
        Select categoryS = new Select(category);
        Select brandS = new Select(brand);
        Select imageS = new Select(image);
       for( Product product : Product.getProducts() ) {
           if(product.getProductName().equals("Młoteczek")) {
               type(name, product.getProductName());
               type(description, product.getProductDescription());
               type(stock, product.getProductStock());
               type(price, product.getProductPrice());
               categoryS.selectByVisibleText(product.getProductCategory());
               brandS.selectByVisibleText(product.getProductBrand());
               imageS.selectByVisibleText(product.getProductImage());
               click(submit);
               break;
           }
       }
       return this;
    }
    public String getAlertText() {
        waitForVisibility(alert);
        return alert.getText();
    }
}
