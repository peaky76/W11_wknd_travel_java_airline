import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Flight {

    ArrayList<Passenger> passengerList;
    private String flightNumber;
    private String arrivalAirport;
    private String departureAirport;
    private LocalDateTime departureTime;
    private Plane plane;

    public Flight(String flightNumber, String arrivalAirport, String departureAirport, LocalDateTime departureTime, Plane plane) {
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.plane = plane;
        this.passengerList = new ArrayList<Passenger>();
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
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

    public void bookPassenger(Passenger passenger) {
        if (getAvailableSeatCount() > 0) {
            this.passengerList.add(passenger);
        }
    }

    public int getAvailableSeatCount() {
        return plane.getPassengerCapacity() - passengerList.size();
    }


}
