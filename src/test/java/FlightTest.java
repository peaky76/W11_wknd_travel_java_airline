import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.EMBRAERERJ145);
        flight = new Flight("AB123", "LBA", "EDI", "12:00 01/09/2020", plane);
        passenger = new Passenger("Fred Bloggs", 2);
    }

    @Test
    public void hasNumber() {
        assertEquals("AB123", flight.getFlightNumber());
    }

    @Test
    public void hasArrivalAirport() {
        assertEquals("LBA", flight.getArrivalAirport());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("EDI", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("12:00 01/09/2020", flight.getDepartureTime());
    }

    @Test
    public void hasPlane() {
        assertEquals(50, flight.getPlane().getCapacity());
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, flight.getPassengerList().size());
    }

    @Test
    public void canBookPassenger() {
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getPassengerList().size());
    }

    @Test
    public void canGetAvailableSeatsCount() {
        flight.bookPassenger(passenger);
        assertEquals(49, flight.getAvailableSeatCount());
    }

    @Test
    public void cannotBookPassengerOnFullFlight() {
        for (int i = 0; i < 50; ++i) {
            flight.bookPassenger(new Passenger("John Doe", 1));
        }
        flight.bookPassenger(passenger);
        assertEquals(false, flight.getPassengerList().contains(passenger));
    }
}
