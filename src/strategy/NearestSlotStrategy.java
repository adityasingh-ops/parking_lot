package strategy;
import java.util.TreeSet;

import Gate.Gate;
import ParkingLot.Floor;
import ParkingLot.ParkingLot;
import Slot.ParkingSlot;
import Vehicle.PowerRequiredVehicle;
import Vehicle.Vehicle;

public class NearestSlotStrategy implements SlotAssignmentStrategy {
    @Override
    public ParkingSlot assignSlot(ParkingLot lot, Vehicle vehicle, Gate entryGate, boolean needsPower) {
        for (Floor floor : lot.getFloors()) {
            TreeSet<ParkingSlot> slots = floor.getSlotsNearGate(entryGate);
            if (slots == null)
                continue;
            for (ParkingSlot slot : slots) {
                if (!slot.isOccupied() &&
                        matchesSize(slot, vehicle) &&
                        matchesPower(slot, needsPower)) {
                    return slot;
                }
            }
        }
        return null;
    }

    private boolean matchesSize(ParkingSlot slot, Vehicle vehicle) {
        return slot.getSize() != null && slot.getSize().equals(vehicle.getRequiredSlotSize());
    }

    private boolean matchesPower(ParkingSlot slot, boolean needsPower) {
        return !needsPower || slot.hasPower();
    }
}