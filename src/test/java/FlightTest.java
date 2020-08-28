import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {


//    an empty list of booked Passenger's
//    a Plane
//    flight number (i.e. "FR756")
//    destination (i.e. GLA, EDI)
//    departure airport (i.e. GLA, EDI)
//    departure time (use a String)

    Flight flight;
    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.EMBRAERERJ145);
        flight = new Flight("AB123", "LBA", "EDI", "12:00 01/09/2020", plane);
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
}
