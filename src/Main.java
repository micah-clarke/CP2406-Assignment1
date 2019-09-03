import java.util.Random;

public class Main {

    public static void main(String args[]) {

        Road road = new Road(2, 10, 5, 0, "01");
        Car car = new Car(2, 1, road.getStartXPosition(), road.getStartYPosition(), 1);

        while (car.getxPosition() <= road.getXFinish() && car.getyPosition() <= road.getYFinish()) {
            if (road.getLength() == 2) {
                car.driveY();
                System.out.println("Car is at x: " + car.getxPosition() + " y: " + car.getyPosition() + " on road: " + road.getRoadID());

            }
            if (road.getHeight() == 2) {
                car.driveY();
                System.out.println("Car is at x: " + car.getxPosition() + " y: " + car.getyPosition() + " on road: " + road.getRoadID());
            }
        }


    }
}



