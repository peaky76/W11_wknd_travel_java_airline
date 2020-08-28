import java.util.Collection;

public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getPassengerCapacity() {
        return planeType.getCapacity();
    }

    public int getMaxWeight() {
        return planeType.getMaxWeight();
    }

    public int getBaggageCapacity() {
        return planeType.getMaxWeight() / 2;
    }

}
