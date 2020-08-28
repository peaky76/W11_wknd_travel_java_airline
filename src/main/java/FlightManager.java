public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getTotalBaggageCapacity() {
        return flight.getPlane().getBaggageCapacity();
    }

    public int getBaggageAllowancePerPassenger() {
        return getTotalBaggageCapacity() / flight.getPlane().getPassengerCapacity();
    }

    public int getBookedBaggageTotal() {
        int baggageTotal = 0;
        for (Passenger p: flight.getPassengerList()) {
            baggageTotal += p.getBagWeight();
        }
        return baggageTotal;
    }

    public int getSpareBaggageCapacity() {
        return getTotalBaggageCapacity() - getBookedBaggageTotal();
    }
}
