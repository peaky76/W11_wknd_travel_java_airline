import java.util.ArrayList;

public class Flight {

    ArrayList<Passenger> passengerList;
    private String flightNumber;
    private String arrivalAirport;
    private String departureAirport;
    private String departureTime;
    private Plane plane;

    public Flight(String flightNumber, String arrivalAirport, String departureAirport, String departureTime, Plane plane) {
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

    public String getDepartureTime() {
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
