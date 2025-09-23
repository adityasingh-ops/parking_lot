package Slot;

import java.util.ArrayList;
import java.util.List;

import Vehicle.Vehicle;

public class ParkingSlot implements Comparable<ParkingSlot> {
    private String id;
    private boolean occupied;
    private Vehicle vehicle;
    private List<SlotDecorator> decorators = new ArrayList<>();

    public ParkingSlot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        occupied = true;
    }

    public void freeSlot() {
        this.vehicle = null;
        occupied = false;
    }

    public void addDecorator(SlotDecorator decorator) {
        decorators.add(decorator);
    }

    public boolean hasPower() {
        return decorators.stream().anyMatch(d -> d instanceof PowerSlotDecorator);
    }

    public String getSize() {
        return decorators.stream()
                .filter(d -> d instanceof SizeDecorator)
                .map(d -> ((SizeDecorator) d).getSize())
                .findFirst().orElse(null);
    }

    // For TreeSet order by distance (example; you can set per gate)
    @Override
    public int compareTo(ParkingSlot other) {
        return id.compareTo(other.id); // Replace with actual distance logic if needed
    }
}
