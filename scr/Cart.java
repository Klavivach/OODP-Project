import java.util.ArrayList;
import java.util.Date;

public class Cart {
    private ArrayList<Order> orders;

    public Cart() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}

