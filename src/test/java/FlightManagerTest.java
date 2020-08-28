import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Plane plane;
    Flight flight;
    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING777);
        flight = new Flight("AB123", "JFK", "MCR", "12:00 01/09/2020", plane);
        flightManager = new FlightManager(flight);
        passenger1 = new Passenger("Fred Bloggs", 1);
        passenger2 = new Passenger("Jo Smith", 2);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
    }

    @Test
    public void canGetTotalBaggageCapacity() {
        assertEquals(10000, flightManager.getTotalBaggageCapacity());
    }

    @Test
    public void canGetBaggageAllowancePerPassenger() {
        assertEquals(25, flightManager.getBaggageAllowancePerPassenger());
    }

    @Test
    public void canGetBookedBaggageTotal() {
        assertEquals(30, flightManager.getBookedBaggageTotal());
    }

    @Test
    public void canGetSpareBaggageCapacity() {
        assertEquals(9970, flightManager.getSpareBaggageCapacity());
    }

}
