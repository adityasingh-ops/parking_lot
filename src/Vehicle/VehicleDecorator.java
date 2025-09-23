package Vehicle;

public class VehicleDecorator extends Vehicle {
    private Vehicle vehicle;

    public VehicleDecorator(Vehicle vehicle) {
        super(vehicle.getLicensePlate(), vehicle.getType());
    }

    @Override
    public VehicleSize getRequiredSlotSize() {
        return vehicle.getRequiredSlotSize();
    }
    
}
