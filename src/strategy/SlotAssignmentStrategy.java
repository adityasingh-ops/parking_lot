package strategy;


import Gate.Gate;
import ParkingLot.ParkingLot;
import Slot.ParkingSlot;
import Vehicle.Vehicle;

public interface SlotAssignmentStrategy {
    ParkingSlot assignSlot(ParkingLot lot, Vehicle vehicle, Gate entryGate, boolean needsPower);
}
