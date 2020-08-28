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
    public void hasCapacity() {
        assertEquals(400, plane.getCapacity());
    }

    @Test
    public void hasMaxWeight() {
        assertEquals(20000, plane.getMaxWeight());
    }

}
