package Gate;
import ParkingLot.Floor;

public class Gate {
    private String id;
    private String gateType; // "ENTRY" or "EXIT"
    private Floor floor;

    public Gate(String id, String gateType, Floor floor) {
        this.id = id;
        this.gateType = gateType;
        this.floor = floor;
    }

    public String getId() {
        return id;
    }

    public String getGateType() {
        return gateType;
    }

    public Floor getFloor() {
        return floor;
    }
}