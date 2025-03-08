package Cart;

import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItemList;

    public Cart() {
        this.cartItemList = new ArrayList<>();
    }

    public void printCartDetails() {
        for (CartItem cartItem : this.cartItemList) {
            cartItem.printDetails();
        }
    }

    public void addCartItem(Product product, int numberOfItems) {
        CartItem cartItem = new CartItem().setProduct(product).setNumberOfItems(numberOfItems);
        this.cartItemList.add(cartItem);
    }

    public void toggleCheckBoxForOrderForCartItem(int index) {
        this.cartItemList.get(index).toggleCheckBoxForOrder();
    }

    public List<CartItem> getCartItemList() {
        return  this.cartItemList;
    }

    public class CartItem {
        private Product product;

        private  int numberOfItems;

        private long totalPrice;

        private boolean isCheckedForOrder;

        private CartItem() {
            this.isCheckedForOrder = true;
        }
        public CartItem setProduct(Product product) {
            this.product  = product;
            return this;
        }

        public Product getProduct() {
            return this.product;
        }

        public int getNumberOfItems() {
            return this.numberOfItems;
        }

        public long getTotalPrice() {
            return this.totalPrice;
        }

        public CartItem setNumberOfItems(int numberOfItems) {
            this.numberOfItems = numberOfItems;
            this.totalPrice = this.product.getPrice() * this.numberOfItems;
            return  this;
        }

        public void toggleCheckBoxForOrder() {
            this.isCheckedForOrder = !this.isCheckedForOrder;
        }

        public boolean getToggleCheckBoxForOrder() {
            return this.isCheckedForOrder;
        }
        public void printDetails() {
            System.out.println("Name of the product: " + product.getProductName());
            System.out.println("Total number of items: " + this.numberOfItems);
            System.out.println("Total price: " + this.totalPrice);
            System.out.println("CheckBox for order: " + this.isCheckedForOrder);
            System.out.println("**********************************************************");
        }
    }
}
