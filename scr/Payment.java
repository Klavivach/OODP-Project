import java.util.Random;

public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private boolean isPaymentSuccessful;

    public Payment(double amount, String paymentMethod) {
        this.paymentId = generatePaymentId();
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isPaymentSuccessful = processPayment();
    }

    private String generatePaymentId() {
        Random rand = new Random();
        String paymentId = String.format("P%04d", rand.nextInt(10000));
        return paymentId;
    }

    private boolean processPayment() {
        // Code for processing payment using the specified payment method
        // Returns true if payment is successful, false otherwise
        // ...
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }
}
