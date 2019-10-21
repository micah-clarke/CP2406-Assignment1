import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoadTest {
    @Test
    public void initializer(){
        Road road = new Road(10, 2, 5, 2, 1);
        assertEquals(10, road.getLength());
        assertEquals(2, road.getHeight());
        assertEquals(0, road.getStartXPosition());
        assertEquals(0, road.getStartYPosition());
        assertEquals("1", road.getRoadID());
    }

}