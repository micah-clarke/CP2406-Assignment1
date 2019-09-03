import java.util.Random;

public class Main {

    public static void main(String args[]) {

        Road road = new Road(2, 10, 5, 0, "01");
        Car car = new Car(2, 1, road.getStartXPosition(), road.getStartYPosition(), 1);
        Road road1 = new Road(10, 2, 0, 11, "02");
        TrafficLight trafficLight = new TrafficLight(true, false);
        int waitTime = 0;

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

        if (car.getyPosition() == road1.getStartYPosition()) {
            double direction = ( + Math.random( ) );
                if (road1.getHeight() == 2) {
                    while (trafficLight.isXGreen()) {
                        car.stopX();
                        waitTime += 1;
                        System.out.println("Car is waiting at a traffic light on road " + road.getRoadID());
                        if (waitTime == 10){
                            trafficLight.changeX();
                        }

                    }
                        if (direction > 0.5) {
                            car.setSpeed(-car.getSpeed());
                            System.out.println("Car turned left onto road " + road1.getRoadID());
                            while (car.getxPosition() <= road1.getXFinish() && car.getxPosition() >= road1.getStartXPosition()) {
                                car.driveX();
                                System.out.println("Car is at x: " + car.getxPosition() + " y: " + car.getyPosition() + " on road: " + road1.getRoadID());
                            }

                        } else {
                            System.out.println("Car turned right onto road " + road1.getRoadID());
                            while (car.getxPosition() <= road1.getXFinish()) {
                                car.driveX();
                                System.out.println("Car is at x: " + car.getxPosition() + " y: " + car.getyPosition() + " on road: " + road1.getRoadID());
                            }


                        }
                }
                else{
                    System.out.println("Car continued onto road " + road1.getRoadID());
                    while (car.getyPosition() <= road1.getYFinish() && car.getyPosition() >= road1.getStartYPosition())
                    car.driveY();
                }
        }

    }
}



