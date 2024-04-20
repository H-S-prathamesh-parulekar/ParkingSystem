package vehicles;

public class VehicleSpace {
    private int spaceNumber;
    private boolean availability;
    private VehicleType type;

    public VehicleSpace(int spaceNumber, VehicleType type) {
        this.spaceNumber = spaceNumber;
        this.availability = true; // Initially available
        this.type = type; // Assign the vehicle type
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isAvailable() {
        return availability;
    }

    public VehicleType getType() {
        return type;
    }

    public void occupy() {
        availability = false;
    }

    public void vacate() {
        availability = true;
    }
}
