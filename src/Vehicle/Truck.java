package Vehicle;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }

    @Override
    public VehicleSize getRequiredSlotSize() {
        return VehicleSize.LARGE;
    }
}
