package Ticket;

import java.util.UUID;

import Slot.ParkingSlot;
import Vehicle.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot assignedSlot;
    private long entryTime;

    public Ticket(Vehicle vehicle, long entryTime) {
        this.ticketId = java.util.UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getAssignedSlot() {
        return assignedSlot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setAssignedSlot(ParkingSlot slot) {
        this.assignedSlot = slot;
    }

}
