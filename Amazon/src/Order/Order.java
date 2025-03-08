package Order;

import Cart.Cart;
import Product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;

    private LocalDate orderDate;

    private List<OrderItem> orderItemList;
    public Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = LocalDate.now();
        this.orderItemList = new ArrayList<>();
    }

    public void addOrderItem(Product product, int numberOfItems, long totalPrice) {
        OrderItem orderItem = new OrderItem().setProduct(product).setNumberOfItems(numberOfItems).setTotalPrice(totalPrice);
        this.orderItemList.add(orderItem);
    }

    public void printOrderDetails() {
        for(OrderItem orderItem: this.orderItemList) {
            orderItem.printDetails();
        }
    }
    private class OrderItem {
        private Product product;

        private int numberOfItems;

        private long totalPrice;

        private OrderItemStatus orderItemStatus;

        public OrderItem() {
            this.orderItemStatus = OrderItemStatus.PLACED;
        }

        public OrderItem setProduct(Product product) {
            this.product = product;
            return this;
        }

        public OrderItem setNumberOfItems(int numberOfItems) {
            this.numberOfItems = numberOfItems;
            return this;
        }

        public OrderItem setTotalPrice(long totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public void printDetails() {
            System.out.println("Name of the product: " + product.getProductName());
            System.out.println("Total number of items: " + this.numberOfItems);
            System.out.println("Total price: " + this.totalPrice);
            System.out.println("Order Id: " + orderId);
            System.out.println("Order date: " + orderDate);
            System.out.println("Order item status: " +this.orderItemStatus);
            System.out.println("**********************************************************");
        }
    }
}
