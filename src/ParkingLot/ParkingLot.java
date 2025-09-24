package ParkingLot;

import java.util.List;


import Gate.Gate;
import Slot.ParkingSlot;
import Ticket.PaymentReceipt;
import Ticket.Receipt;
import Ticket.Ticket;
import Vehicle.PowerRequiredVehicle;
import Vehicle.Vehicle;
import strategy.NearestSlotStrategy;
import strategy.SlotAssignmentStrategy;

public class ParkingLot {
    private List<Floor> floors;
    private List<Gate> gates;
    private SlotAssignmentStrategy strategy;
    private PaymentFactory paymentFactory;

    public ParkingLot(List<Floor> floors, List<Gate> gates, PaymentFactory paymentFactory) {
        this.floors = floors;
        this.gates = gates;
        this.strategy = new NearestSlotStrategy();
        this.paymentFactory = paymentFactory;
    }

    public void setStrategy(SlotAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public Ticket enter(Vehicle vehicle, Gate entryGate) {
        boolean needsPower = false;
        if (vehicle instanceof PowerRequiredVehicle) {
            needsPower = ((PowerRequiredVehicle) vehicle).needsPower();
        }
        ParkingSlot slot = strategy.assignSlot(this, vehicle, entryGate, needsPower);
        if (slot == null)
            return null; // No available slot
        slot.assignVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle, System.currentTimeMillis());
        ticket.setAssignedSlot(slot);
        return ticket;
    }

    public PaymentReceipt exit(Ticket ticket, String paymentMethod) {
        ParkingSlot slot = ticket.getAssignedSlot();
        Vehicle vehicle = slot.freeSlot();
        // Calculate hours parked; flat rate for demo
        long entryTime = ticket.getEntryTime();
        long exitTime = System.currentTimeMillis();
        double amount = (exitTime - entryTime) / (1000.0 * 60.0 * 60.0) * 40; // ₹40/hour
        boolean paid = paymentFactory.pay(vehicle, amount, paymentMethod);
        if (!paid)
            return null; // Payment failed
        return new PaymentReceipt(entryTime, exitTime, amount, paymentMethod);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
