import Cart.Cart;
import Category.Category;
import Order.Order;
import Product.Product;
import Product.Shirt;
import Product.Trouser;
import Category.DressCategory;
import Person.Person;
import Category.ShoeCategory;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Gajanan", "Hegde", "gajanan", "123");

        Product peterEngland = new Shirt(1, "PeterEnglandShirt", 1000);
        Product levis = new Shirt(1, "LevisShirt", 2000);
        Product usPolo = new Trouser(1, "USPoloTrouser", 2500);

        Product nike = new Shirt(1, "Nike", 1000);
        Product adidas = new Shirt(1, "Adidas", 2000);
        Product puma = new Trouser(1, "Puma", 2500);

        Category dressCategory = DressCategory.getDressCategoryInstance(1, "DressCategory");
        dressCategory.addProduct(peterEngland);
        dressCategory.addProduct(levis);
        dressCategory.addProduct(usPolo);

        ShoeCategory shoeCategory = ShoeCategory.getShoeCategoryInstance(2, "ShoeCategory");
        shoeCategory.addProduct(nike);
        shoeCategory.addProduct(adidas);
        shoeCategory.addProduct(puma);

        Cart  cart = new Cart();
        cart.addCartItem(peterEngland, 10);
        cart.addCartItem(usPolo, 10);
        cart.addCartItem(nike, 5);

        cart.toggleCheckBoxForOrderForCartItem(0);

        cart.printCartDetails();

        System.out.println("----------------------------------------------------------------------------------------------------");
        Order order = new Order("1");
        List<Cart.CartItem>  cartItemList = cart.getCartItemList();
        for (Cart.CartItem tempCartItem : cartItemList) {
            if (tempCartItem.getToggleCheckBoxForOrder()) {
                order.addOrderItem(tempCartItem.getProduct(), tempCartItem.getNumberOfItems(), tempCartItem.getTotalPrice());
            }
        }

        order.printOrderDetails();
    }
}