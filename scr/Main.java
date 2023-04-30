import javax.sql.rowset.serial.SerialDatalink;
public class Main {
    public static void main(String[] args) {
        //ย้ายไปไว้ในเมน
        Order order = new Order("123456", "XYZ-123", 2, 50.0, "123 Main St, Anytown, USA");
        // Process payment and update order status to "Shipped"
        Date deliveryDate = new Date();
        String trackingNumber = "1234567890";
        order.setDeliveryInfo(deliveryDate, trackingNumber); 
    }
}

