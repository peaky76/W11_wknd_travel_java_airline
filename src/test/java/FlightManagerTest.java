import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    DateTimeFormatter dateFormatter;
    LocalDateTime departureTime;

    Plane plane;
    Flight flight;
    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before() {

        dateFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MMM-yyyy");
        departureTime = LocalDateTime.parse("12:00 01-Sep-2020", dateFormatter);

        plane = new Plane(PlaneType.BOEING777);
        flight = new Flight("AB123", "JFK", "MCR", departureTime, plane);
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
