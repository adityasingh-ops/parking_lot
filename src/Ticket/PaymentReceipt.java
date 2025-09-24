package Ticket;

public class PaymentReceipt extends Receipt {
    private double amountPaid;
    private String paymentMethod;

    public PaymentReceipt(long entryTime, long exitTime, double amountPaid, String paymentMethod) {
        super(entryTime, exitTime);
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
