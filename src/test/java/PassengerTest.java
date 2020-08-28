import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Fred Bloggs", 2);
    }

    @Test
    public void hasName() {
        assertEquals("Fred Bloggs", passenger.getName());
    }

    @Test
    public void hasBagCount() {
        assertEquals(2, passenger.getBagCount());
    }
}
