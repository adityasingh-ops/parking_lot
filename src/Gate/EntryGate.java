package Gate;

import Ticket.Ticket;
import Vehicle.Vehicle;

public class EntryGate {
    private int gateId;

    public EntryGate(int gateId) {
        this.gateId = gateId;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        return new Ticket(vehicle, System.currentTimeMillis());
    }
}
