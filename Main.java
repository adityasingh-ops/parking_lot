import java.util.*;

import Gate.Gate;
import ParkingLot.Floor;
import ParkingLot.ParkingLot;
import ParkingLot.PaymentFactory;
import Slot.ParkingSlot;
import Slot.PowerSlotDecorator;
import Slot.SizeDecorator;
import Ticket.Ticket;
import Vehicle.*;

public class Main {
    public static void main(String[] args) {
        // Setup some slots
        ParkingSlot bikeSlot = new ParkingSlot("F1-B1");
        bikeSlot.addDecorator(new SizeDecorator("SMALL"));
        ParkingSlot carSlot = new ParkingSlot("F1-C1");
        carSlot.addDecorator(new SizeDecorator("MEDIUM"));
        ParkingSlot poweredCarSlot = new ParkingSlot("F1-C2");
        poweredCarSlot.addDecorator(new SizeDecorator("MEDIUM"));
        poweredCarSlot.addDecorator(new PowerSlotDecorator());
        ParkingSlot truckSlot = new ParkingSlot("F1-T1");
        truckSlot.addDecorator(new SizeDecorator("LARGE"));
        truckSlot.addDecorator(new PowerSlotDecorator());
        List<ParkingSlot> slots = Arrays.asList(
                bikeSlot, carSlot, poweredCarSlot, truckSlot);

        // Setup floor and gates
        Gate entryGate1 = new Gate("G1", "ENTRY", null); // Floor is set later
        Gate entryGate2 = new Gate("G2", "ENTRY", null);
        Gate exitGate = new Gate("G3", "EXIT", null);
        List<Gate> gates = Arrays.asList(entryGate1, entryGate2, exitGate);

        Floor groundFloor = new Floor(0, slots, gates);
        // Set floor in gates
        for (Gate gate : gates) {
            // In real code, use a setter or constructor that links gates and floors
            // For clarity, we’re just bypassing this in the sample
        }

        // Create parking lot with the floor and gates
        ParkingLot lot = new ParkingLot(Arrays.asList(groundFloor), gates, new PaymentFactory());

        // Enter vehicles
        Vehicle bike = new Bike("Bike-001");
        Vehicle car = new Car("CAR-001");
        Vehicle electricCar = new PowerRequiredVehicle(new Car("CAR-E"));
        Vehicle truck = new Truck("TRUCK-001");

        Ticket t1 = lot.enter(bike, entryGate1);
        System.out.println("Bike assigned: " + (t1 != null ? t1.getAssignedSlot().getId() : "DENIED"));
        Ticket t2 = lot.enter(car, entryGate1);
        System.out.println("Car assigned: " + (t2 != null ? t2.getAssignedSlot().getId() : "DENIED"));
        Ticket t3 = lot.enter(electricCar, entryGate1);
        System.out.println("Electric Car assigned: " + (t3 != null ? t3.getAssignedSlot().getId() : "DENIED"));
        Ticket t4 = lot.enter(truck, entryGate1);
        System.out.println("Truck assigned: " + (t4 != null ? t4.getAssignedSlot().getId() : "DENIED"));

        // Exit vehicles (simplified)
        lot.exit(t1, "CASH");
        lot.exit(t2, "CASH");
        lot.exit(t3, "CASH");
        lot.exit(t4, "CARD");
    }
}
