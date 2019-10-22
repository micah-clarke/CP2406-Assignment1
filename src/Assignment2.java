import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Assignment2 extends JFrame implements ActionListener {
    private JButton newRoad = new JButton("Add Road");
    private JButton editMode = new JButton("Edit mode");
    private JButton runMode = new JButton("Run mode");
    private JButton startRun = new JButton("Start simulation");
    private JButton saveRoads = new JButton("Save Roads");
    private static JPanel allOfTheRoads = new JPanel();
    private static DrawRoad drawRoad = new DrawRoad();
    static ArrayList<Road> roads = new ArrayList<>();
    private static ArrayList<Crossroads> crossroadList = new ArrayList<>();
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Road> uniqueSpawnList = new ArrayList<>();
    private int carID = 1;
    private int spawnRoadID = 1;
    private boolean keepDriving;




    private Assignment2() {
        setTitle("Assignment 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        newRoad.setPreferredSize(new Dimension(100, 40));
        editMode.setPreferredSize(new Dimension(100, 40));
        runMode.setPreferredSize(new Dimension(100, 40));
        startRun.setPreferredSize(new Dimension(100, 40));
        saveRoads.setPreferredSize(new Dimension(100, 40));
        JButton nextStep = new JButton("Next step");
        nextStep.setPreferredSize(new Dimension(10,10));


        add(newRoad, "West");
        add(editMode, "East");
        add(runMode, "North");
        add(startRun, "South");
//        add(nextStep, "Center");

        JLabel output = new JLabel();
        add(saveRoads, "North");
        saveRoads.setVisible(false);
        newRoad.addActionListener(this);
        editMode.addActionListener(this);
        startRun.addActionListener(this);
        runMode.addActionListener(this);
        saveRoads.addActionListener(this);
        output.setVisible(true);
        startRun.setVisible(true);
        runMode.setVisible(true);
        newRoad.setVisible(false);
        drawRoad.setVisible(false);
        nextStep.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        output.setSize(500, 500);
        allOfTheRoads.setSize(500, 500);
        add(allOfTheRoads, "Center");

        if (source == editMode) {
            runMode.setVisible(false);
            newRoad.setVisible(true);
            saveRoads.setVisible(true);
            drawAllRoads();
//            System.out.println("Pressed edit mode");

        } else if (source == newRoad) {


            for (Road road : roads) {
                System.out.println(road.getStartXPosition() + " + " + road.getStartYPosition() + " + " + road.getXFinish() + " + " + road.getStartYPosition());
            }
            crossroadList.clear();


            drawRoad.setVisible(true);
//            System.out.println("1 start x " + drawRoad.getPointStartX() + " Start y " + drawRoad.getPointStartY() + " end x " + drawRoad.getFinalEndX() + " end y " + drawRoad.getFinalEndY());
//            System.out.println(drawRoad.getPointStartX() + drawRoad.getPointStartY() + drawRoad.getFinalEndX() + drawRoad.getFinalEndY());
//            System.out.println("Pressed new road");

        } else if (source == saveRoads) {
            startRun.setVisible(true);
            runMode.setVisible(true);
            newRoad.setVisible(false);
            saveRoads.setVisible(false);
            drawAllRoads();
//            System.out.println("Pressed save roads");


        } else if (source == startRun) {
            uniqueSpawnList.clear();
            for (Road currentRoad : roads) {
                if (currentRoad.getStartYPosition() >= 500 || currentRoad.getStartXPosition() <= 0 || currentRoad.getStartYPosition() <= 0 || currentRoad.getStartXPosition() >= 500 || currentRoad.getXFinish() <= 0 || currentRoad.getXFinish() >= 500 || currentRoad.getYFinish() <= 0 || currentRoad.getYFinish() >= 500) {
                    Road road = new Road(currentRoad.getStartXPosition(), currentRoad.getStartYPosition(), currentRoad.getXFinish(), currentRoad.getYFinish(), spawnRoadID);
                    spawnRoadID += 1;
                    uniqueSpawnList.add(road);
                }
            }
            getCrossroads();

            for (Car car : cars) {
                System.out.println("Car x position is: " + car.getxPosition());
            }
//            System.out.println("Unique spawn list is: " + uniqueSpawnList);
//            System.out.println("FROM ASSIGNMENT 2");
//            for (Road road : roads) {
//                System.out.println("Start X: " + road.getStartXPosition());
//                System.out.println("Start Y: " + road.getStartYPosition());
//                System.out.println("End X: " + road.getXFinish());
//                System.out.println("End Y: " + road.getYFinish());
//
//
//            }
            int numberOfCrossroads = crossroadList.size();
            Random randomSpawns = new Random();
            int chanceOfSpawning = randomSpawns.nextInt(11);
            if (chanceOfSpawning > 0) {
                int spawnOptions = randomSpawns.nextInt(numberOfCrossroads + 1);
                for (int spawnLocation = 0; spawnLocation < uniqueSpawnList.size() - 1; spawnLocation++) {
                    System.out.println("Spawn location: " +spawnLocation);
                    System.out.println("Spawn options: "+spawnOptions);
                    System.out.println("Unique spawn list size: " + uniqueSpawnList.size());

                    if (spawnLocation == spawnOptions) {
                        Car car = new Car(10, 10, uniqueSpawnList.get(spawnLocation).getStartXPosition(), uniqueSpawnList.get(spawnLocation).getStartYPosition(), 1, carID);
                        System.out.println("Car "+ carID + " has been created at: " +car.getxPosition() + car.getyPosition());
                        carID += 1;
                        while(keepDriving){
                            for (Car value : cars) {
                                if (value.getyPosition() <= 0) {
                                    car.setDrivingDown(true);
                                    car.setDrivingLeft(false);
                                    car.setDrivingRight(false);
                                    car.setDrivingUp(false);

                                    car.setPreviousYPosition(car.getyPosition());
                                    car.setSpeed(10);
                                    car.driveY();
                                } else if (value.getxPosition() >= 500) {
                                    car.setDrivingDown(false);
                                    car.setDrivingLeft(true);
                                    car.setDrivingRight(false);
                                    car.setDrivingUp(false);
                                    car.setSpeed(-10);
                                    car.driveY();
                                } else if (value.getxPosition() <= 0) {
                                    car.setDrivingDown(false);
                                    car.setDrivingLeft(false);
                                    car.setDrivingRight(true);
                                    car.setDrivingUp(false);
                                    car.setSpeed(10);
                                    car.driveY();
                                } else if (value.getyPosition() >= 500) {
                                    car.setDrivingDown(false);
                                    car.setDrivingLeft(false);
                                    car.setDrivingRight(false);
                                    car.setDrivingUp(true);
                                    car.setSpeed(-10);
                                    car.driveX();
                                }
                                for (Crossroads crossroads : crossroadList) {
                                    if(car.isDrivingDown()){
                                        keepDriving = car.getyPosition() + 10 != crossroads.getyIntercept() || car.getxPosition() != crossroads.getxIntercept();

                                    }
                                    else if(car.isDrivingUp()){
                                        keepDriving = car.getyPosition() - 10 != crossroads.getyIntercept() || car.getxPosition() != crossroads.getxIntercept();
                                    }
                                    else if(car.isDrivingLeft()){
                                        keepDriving = car.getxPosition() - 10 != crossroads.getxIntercept() || car.getyPosition() != crossroads.getxIntercept();
                                    }
                                    else if(car.isDrivingRight()){
                                        keepDriving = car.getxPosition() + 10 != crossroads.getxIntercept() || car.getyPosition() != crossroads.getxIntercept();
                                    }
                                }

                        }

                            System.out.println(car.getxPosition() + car.getyPosition());

                        }

                        for (Car value : cars) {

                            System.out.println("Car is at: " +value.getxPosition());
                            System.out.println("Car is at: " +value.getyPosition());

                        }
                    }
                }

            }

        }
        else {

            runMode.setVisible(false);
            newRoad.setVisible(false);
            drawAllRoads();
        }

    }

    static void reDraw() {
        allOfTheRoads.getGraphics().drawLine(drawRoad.getPointStartX(), drawRoad.getPointStartY(), drawRoad.getFinalEndX(), drawRoad.getFinalEndY());
    }

    private void drawAllRoads() {
        for (Road drawnRoad : Assignment2.roads) {
            System.out.println(drawnRoad.getXFinish() - drawnRoad.getStartXPosition());
            System.out.println(drawnRoad.getYFinish() - drawnRoad.getStartYPosition());
            getGraphics().drawLine(drawnRoad.getStartXPosition() + 108, drawnRoad.getStartYPosition() + 71, (drawnRoad.getXFinish()) + 108, (drawnRoad.getYFinish()) + 71);
//            System.out.println(drawnRoad.getStartXPosition() + " + " + drawnRoad.getStartYPosition() + " + " + drawnRoad.getXFinish() + " + " + drawnRoad.getStartYPosition());
        }
    }


    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        assignment2.setSize(800, 800);
        assignment2.setVisible(true);

    }

    private void getCrossroads() {
        crossroadList.clear();
        for (int crossroadIndex = 0; crossroadIndex < roads.size(); ++crossroadIndex) {
            Road selectedRoad = roads.get(crossroadIndex);
            for (int j = 0; j < roads.size(); ++j) {
                if (crossroadIndex != j) {
                    Road currentRoad = roads.get(j);

                    int xIntersect;
                    int yIntersect;

                    if(currentRoad.getStartXPosition()<= selectedRoad.getStartXPosition() && selectedRoad.getStartXPosition() <= currentRoad.getStartXPosition() + currentRoad.getLength() && selectedRoad.getStartYPosition() <= currentRoad.getStartYPosition() && currentRoad.getStartYPosition() <= selectedRoad.getStartYPosition() + selectedRoad.getHeight()){
                        yIntersect = selectedRoad.getStartYPosition();
                        xIntersect = currentRoad.getStartXPosition();
                        Crossroads crossroads = new Crossroads(xIntersect, yIntersect);
                        crossroadList.add(crossroads);
                    }
//                    System.out.println("Current roads");
//                    System.out.println(currentRoad.getHeight());
//                    System.out.println(currentRoad.getLength());
//                    System.out.println(currentRoad.getStartXPosition());
//                    System.out.println(currentRoad.getStartYPosition());
                }
            }
//            System.out.println("Selected roads ");
//            System.out.println(selectedRoad.getHeight());
//            System.out.println(selectedRoad.getLength());
//            System.out.println(selectedRoad.getStartXPosition());
//            System.out.println(selectedRoad.getStartYPosition());

        }
        System.out.println("Roads: " + roads);
        System.out.println("Crossroads: " +crossroadList);
        for (Crossroads crossroads : crossroadList) {
            System.out.println("Crossroad x: " + crossroads.getxIntercept());
            System.out.println("Crossroad x: " + crossroads.getyIntercept());
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.blue);
        for (Car car : cars) {
            g.drawLine(car.getxPosition(), car.getyPosition(), car.getxPosition() + 10, car.getyPosition() + 10);
        }

    }


}
