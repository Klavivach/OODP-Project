import java.util.Date;

public class Order {
    private String orderId;
    private String productId;
    private int quantity;
    private double totalPrice;
    private String shippingAddress;
    private Date orderDate;
    private Date deliveryDate;
    private String trackingNumber;

    public Order(String orderId, String productId, int quantity, double totalPrice, String shippingAddress) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.orderDate = new Date();
    }

    public void setDeliveryInfo(Date deliveryDate, String trackingNumber) {
        this.deliveryDate = deliveryDate;
        this.trackingNumber = trackingNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}

//ย้ายไปไว้ในเมน
Order order = new Order("123456", "XYZ-123", 2, 50.0, "123 Main St, Anytown, USA");
// Process payment and update order status to "Shipped"
Date deliveryDate = new Date();
String trackingNumber = "1234567890";
order.setDeliveryInfo(deliveryDate, trackingNumber);
