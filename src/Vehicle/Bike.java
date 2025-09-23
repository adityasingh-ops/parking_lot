package Vehicle;

public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }

    @Override
    public VehicleSize getRequiredSlotSize() {
        return VehicleSize.SMALL;
    }
    
}
