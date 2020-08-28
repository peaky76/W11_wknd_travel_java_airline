import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    DateTimeFormatter dateFormatter;
    LocalDateTime departureTime;

    Flight flight;
    Plane plane;
    Passenger passenger;

    @Before
    public void before() {

        dateFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MMM-yyyy");
        departureTime = LocalDateTime.parse("12:00 01-Sep-2020", dateFormatter);

        plane = new Plane(PlaneType.EMBRAERERJ145);
        flight = new Flight("AB123", "LBA", "EDI", departureTime, plane);

        passenger = new Passenger("Fred Bloggs", 2);
        flight.bookPassenger(passenger);
    }

    @Test
    public void hasName() {
        assertEquals("Fred Bloggs", passenger.getName());
    }

    @Test
    public void hasBagCount() {
        assertEquals(2, passenger.getBagCount());
    }

    @Test
    public void hasBagWeight() {
        assertEquals(20, passenger.getBagWeight());
    }

    @Test
    public void canGetFlightIfBooked() {
        assertEquals(flight, passenger.getBookedFlight());
    }

    @Test
    public void canGetSeatNumberIfBooked() {
        assertEquals(true, passenger.getSeatNumber() > 0 && passenger.getSeatNumber() <= 50);
    }

}
