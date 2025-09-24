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

    public boolean hasPower() {
        return decorators.stream().anyMatch(d -> d instanceof PowerSlotDecorator);
    }

    public String getSize() {
        return decorators.stream()
                .filter(d -> d instanceof SizeDecorator)
                .map(d -> ((SizeDecorator) d).getSize())
                .findFirst().orElse(null);
    }

    public Vehicle assignVehicle(Vehicle v) {
        this.vehicle = v;
        occupied = true;
        return v;
    }

    public Vehicle freeSlot() {
        Vehicle v = this.vehicle;
        this.vehicle = null;
        occupied = false;
        return v;
    }

    public void addDecorator(SlotDecorator decorator) {
        decorators.add(decorator);
    }

    public List<SlotDecorator> getDecorators() {
        return decorators;
    }

    @Override
    public int compareTo(ParkingSlot other) {
        // Replace with real distance-from-gate logic if needed
        return id.compareTo(other.id);
    }
}
