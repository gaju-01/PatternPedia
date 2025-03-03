package Product;

public class Shirt extends Product{

    private  int price;
    public Shirt(int productId, String productName, int price) {
        super(productId, productName);
        this.price = price;
    }
}
