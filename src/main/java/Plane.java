public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getCapacity() {
        return planeType.getCapacity();
    }

    public int getMaxWeight() {
        return planeType.getMaxWeight();
    }

    public int getBagWeight() {
        return (getMaxWeight() / 2) / getCapacity();
    }



}
