package ui_tests.models;

import java.util.ArrayList;

public class Product {
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productStock;
    private String productCategory;
    private String productBrand;
    private String productImage;

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductStock() {
        return productStock;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductImage() {
        return productImage;
    }

    public Product(String productName, String productDescription, String productPrice, String productStock,
                   String productCategory, String productBrand, String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.productImage = productImage;
    }

    private static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(
                "Młoteczek",
                "Idealny do wbijania gwoździ",
                "10",
                "50",
                "Hammer",
                "MightyCraft Hardware",
                "Claw Hammer"
        ));

    }

    public static ArrayList<Product> getProducts() {
        return products;
    }



}
