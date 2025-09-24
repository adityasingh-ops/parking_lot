package ParkingLot;

import Payment.CardPayment;
import Payment.CashPayment;
import Payment.PaymentMethod;
import Vehicle.Vehicle;

public class PaymentFactory {
    public boolean pay(Vehicle vehicle, double amount, String method) {
        PaymentMethod payment;
        if ("CASH".equalsIgnoreCase(method)) {
            payment = new CashPayment();
        } else if ("CARD".equalsIgnoreCase(method)) {
            payment = new CardPayment();
        } else {
            return false;
        }
        return payment.pay(amount);
    }
}
