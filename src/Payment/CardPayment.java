package Payment;

public class CardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paying ₹" + amount + " with CARD.");
        return true; 
    }
}