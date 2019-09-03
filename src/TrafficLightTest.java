import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest {
    @Test
    public void initializer(){
        TrafficLight trafficLight = new TrafficLight(false, false);
        assertFalse(trafficLight.isXGreen());
        assertFalse(trafficLight.isYGreen());
        trafficLight.changeX();
        trafficLight.changeY();
        assertTrue(trafficLight.isXGreen());
        assertTrue(trafficLight.isYGreen());
    }

}