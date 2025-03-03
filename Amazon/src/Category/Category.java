package Category;

import Product.Product;

import java.util.List;

public abstract class Category {

    private int categoryId;

    private String categoryName;

    private List<Product> productList;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
}
