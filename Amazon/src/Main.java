import Category.Category;
import Product.Product;
import Product.Shirt;
import Product.Trouser;
import Category.DressCategory;
public class Main {
    public static void main(String[] args) {
        Product peterEngland = new Shirt(1, "PeterEnglandShirt", 1000);
        Product levis = new Shirt(1, "LevisShirt", 2000);
        Product usPolo = new Trouser(1, "USPoloTrouser", 2500);

        Category dressCategory = DressCategory.getDressCategory(1, "DressCategory");
        dressCategory.addProduct(peterEngland);
        dressCategory.addProduct(levis);
        dressCategory.addProduct(usPolo);


    }
}