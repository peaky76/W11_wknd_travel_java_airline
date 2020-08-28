import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING777);
    }

    @Test
    public void canGetPassengerCapacity() {
        assertEquals(400, plane.getPassengerCapacity());
    }

    @Test
    public void canGetMaxWeight() {
        assertEquals(20000, plane.getMaxWeight());
    }

    @Test
    public void canGetBaggageCapacity() {
        assertEquals(10000, plane.getBaggageCapacity());
    }

}
