package Vehicle;

public class PowerRequiredVehicle extends VehicleDecorator {
    private Vehicle vehicle;

    public PowerRequiredVehicle(Vehicle vehicle) {
        super(vehicle);
        this.vehicle = vehicle;
    }

    public boolean needsPower(){
        return true;
    }
    public Vehicle getBasVehicle(){
        return vehicle;
    }
    
}
