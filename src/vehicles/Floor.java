package vehicles;

public class Floor {
    private int floorNumber;
    private VehicleSpace[] spaces;

    public Floor(int floorNumber, int spacesPerFloor) {
        this.floorNumber = floorNumber;
        this.spaces = new VehicleSpace[spacesPerFloor];
        initializeSpaces();
    }

    private void initializeSpaces() {
        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = new VehicleSpace(i + 1, VehicleType.CAR); // Assuming default VehicleType is CAR
        }
    }


    public int findAvailableSpace(VehicleType type) {

        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i].isAvailable() && spaces[i].getType() == type) {
                return spaces[i].getSpaceNumber(); // Return space number
            }
        }
        return -1; // No available space
    }


    public void occupySpace(int spaceNumber) {
        spaces[spaceNumber - 1].occupy();
    }

    public void vacateSpace(int spaceNumber) {
        spaces[spaceNumber - 1].vacate();
    }
}
