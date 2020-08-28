import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Flight {

    private String flightNumber;
    private String arrivalAirport;
    private String departureAirport;
    private LocalDateTime departureTime;
    private Plane plane;
    private ArrayList<Passenger> passengerList;
    private List<Integer> unassignedSeats;

    public Flight(String flightNumber, String arrivalAirport, String departureAirport, LocalDateTime departureTime, Plane plane) {
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.plane = plane;
        this.passengerList = new ArrayList<Passenger>();
        // Creates an array of unassigned seats from number 1 to the max capacity of the plane.
        this.unassignedSeats = IntStream.rangeClosed(1, plane.getPassengerCapacity()).boxed().collect(Collectors.toList());
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public List<Integer> getUnassignedSeats() {
        return unassignedSeats;
    }

    public int getAvailableSeatCount() {
        return plane.getPassengerCapacity() - passengerList.size();
    }

    public void bookPassenger(Passenger passenger) {
        if (getAvailableSeatCount() > 0) {
            this.passengerList.add(passenger);
            passenger.setBookedFlight(this);
            assignSeat(passenger);
        }
    }

    private void assignSeat(Passenger passenger) {
        int assignedSeat = selectRandomUnassignedSeat();
        passenger.setSeatNumber(assignedSeat);
        unassignedSeats.remove((Object) assignedSeat);
    }

    private int selectRandomUnassignedSeat() {
        int randomIndex = new Random().nextInt(unassignedSeats.size());
        return unassignedSeats.get(randomIndex);
    }

}
