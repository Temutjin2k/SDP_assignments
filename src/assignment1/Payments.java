package assignment1;

public class Payments {

    // Payment interface (Abstraction)
    public interface Payment {
        double getAmount();
        void processPayment();
    }

    // PaymentProcessor class depends on the Payment interface (DIP)
    public static class PaymentProcessor {
        private final Payment payment;

        public PaymentProcessor(Payment payment) {
            this.payment = payment;
        }

        public void process() {
            payment.processPayment();
        }
    }

    public static class CreditCardPayment implements Payment {
        private final double amount;

        public CreditCardPayment(double amount) {
            this.amount = amount;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public void processPayment() {
            System.out.println("Processing Credit Card payment of $" + amount);
        }
    }

    public static class PayPalPayment implements Payment {
        private final double amount;

        public PayPalPayment(double amount) {
            this.amount = amount;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public void processPayment() {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    public static class KaspiGold implements Payment {
        private final double amount;

        public KaspiGold(double amount) {
            this.amount = amount;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public void processPayment() {
            System.out.println("Processing Kaspi Gold payment of $" + amount);
        }
    }

    public static void main(String[] args) {
        // Processing Credit Card Payment
        Payment creditCardPayment = new CreditCardPayment(150.0);
        PaymentProcessor creditCardProcessor = new PaymentProcessor(creditCardPayment);
        creditCardProcessor.process();

        // Processing PayPal Payment
        Payment payPalPayment = new PayPalPayment(200.0);
        PaymentProcessor payPalProcessor = new PaymentProcessor(payPalPayment);
        payPalProcessor.process();

        // Processing KaspiGold Payment
        Payment kaspiGold = new KaspiGold(300.0);
        PaymentProcessor kaspiGoldProcessor = new PaymentProcessor(kaspiGold);
        kaspiGoldProcessor.process();
    }
}
