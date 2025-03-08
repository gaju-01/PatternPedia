package Product;

public class Product {

    private int productId;

    private String productName;

    private long price;

    Product(int productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }

    public String getProductName() {return this.productName;}
}
