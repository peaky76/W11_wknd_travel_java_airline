public enum PlaneType {

    AIRBUSA320(150, 6000),
    BOEING737(140, 6250),
    BOEING777(400, 20000),
    EMBRAERERJ145(50, 1500);

    private int capacity;
    private int maxWeight;

    PlaneType(int capacity, int maxWeight) {
        this.capacity = capacity;
        this.maxWeight = maxWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
