
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void initializer() {
        Car car = new Car(2, 1, 0, 0, 1);
        assertEquals(2, car.getLength());
        assertEquals(1, car.getWidth());
        assertEquals(0, car.getxPosition());
        assertEquals(0, car.getyPosition());
        assertEquals(1, car.getSpeed());
    }
}
