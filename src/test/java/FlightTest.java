import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FlightTest {

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
        assertEquals("2020-09-01T12:00", flight.getDepartureTime().toString());
    }

    @Test
    public void hasPlane() {
        assertEquals(50, flight.getPlane().getPassengerCapacity());
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, flight.getPassengerList().size());
    }

    @Test
    public void startsWithArrayOfUnassignedSeats() {
        assertEquals(50, flight.getUnassignedSeats().size());
        assertEquals((Object) 1, flight.getUnassignedSeats().get(0));
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
        assertEquals(50, flight.getPassengerList().size());
    }

    @Test
    public void cannotDoubleBookSeat() {
        // Book in 50 passengers
        for (int i = 0; i < 50; ++i) {
            flight.bookPassenger(new Passenger("John Doe", 1));
        }
        // Get their seat numbers back into an array list
        ArrayList<Integer> bookedSeatNumbers = new ArrayList<Integer>();
        for (Passenger p: flight.getPassengerList()) {
            bookedSeatNumbers.add(p.getSeatNumber());
        }
        // Convert that list into a list of unique numbers
        List<Integer> uniqueNumbers = bookedSeatNumbers.stream().distinct().collect(Collectors.toList());
        // Check that the lengths of those two lists are equal
        assertEquals(uniqueNumbers.size(), bookedSeatNumbers.size());
    }

}
