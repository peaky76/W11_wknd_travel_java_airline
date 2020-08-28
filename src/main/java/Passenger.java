public class Passenger {

    private String name;
    private int bagCount;
    private final int standardBagWeight = 10;
    private Flight bookedFlight;

    public Passenger(String name, int bagCount) {
        this.name = name;
        this.bagCount = bagCount;
    }

    public String getName() {
        return name;
    }

    public int getBagCount() {
        return bagCount;
    }

    public int getBagWeight() {
        return bagCount * standardBagWeight;
    }

    public Flight getBookedFlight() {
        return bookedFlight;
    }

    public void setBookedFlight(Flight bookedFlight) {
        this.bookedFlight = bookedFlight;
    }
}
