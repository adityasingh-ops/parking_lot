package ParkingLot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import Gate.Gate;
import Slot.ParkingSlot;

public class Floor {
    private int floorNumber;
    private Map<Gate, TreeSet<ParkingSlot>> slotsByGate;
    private List<ParkingSlot> allSlots;
    private List<Gate> gates;

    public Floor(int floorNumber, List<ParkingSlot> slots, List<Gate> gates) {
        this.floorNumber = floorNumber;
        this.allSlots = new ArrayList<>(slots);
        this.gates = gates;
        this.slotsByGate = new HashMap<>();
        for (Gate gate : gates) {
            TreeSet<ParkingSlot> gateSlots = new TreeSet<>();
            for (ParkingSlot slot : slots) {
                // Sort slots by some distance metric (simplify for now)
                gateSlots.add(slot);
            }
            slotsByGate.put(gate, gateSlots);
        }
    }

    public TreeSet<ParkingSlot> getSlotsNearGate(Gate gate) {
        return slotsByGate.get(gate);
    }

    public boolean isFull() {
        return allSlots.stream().allMatch(ParkingSlot::isOccupied);
    }

    public List<ParkingSlot> getSlots() {
        return allSlots;
    }
}
