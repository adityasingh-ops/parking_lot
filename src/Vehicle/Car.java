package Vehicle;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }

    @Override
    public VehicleSize getRequiredSlotSize() {
        return VehicleSize.MEDIUM;
    }
}
