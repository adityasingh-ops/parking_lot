package Payment;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paying ₹" + amount + " in CASH.");
        return true; 
    }
}