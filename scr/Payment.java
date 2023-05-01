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
        public boolean processPayment(double amount, String paymentMethod) {
            // Implement your payment processing logic here
            
            boolean isPaymentSuccessful = false;
            
            // Check if the payment method is valid and supported
            if (paymentMethod.equals("credit card") || paymentMethod.equals("debit card") || paymentMethod.equals("online wallet")) {
                // Process the payment
                // Here, you could use a third-party payment processing library or API to handle the actual payment processing
                // For simplicity, we'll just assume that the payment is successful if the amount is greater than 0
                if (amount > 0) {
                    isPaymentSuccessful = true;
                    System.out.println("Payment of $" + amount + " via " + paymentMethod + " processed successfully.");
                } else {
                    System.out.println("Invalid payment amount. Payment not processed.");
                }
            } else {
                System.out.println("Invalid payment method. Payment not processed.");
            }
            
            return isPaymentSuccessful;
        }
        
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
