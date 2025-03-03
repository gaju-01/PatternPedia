package Product;

public class Trouser extends Product{

    private int price;
    public Trouser(int productId, String productName, int price) {
        super(productId, productName);
        this.price = price;
    }
}
