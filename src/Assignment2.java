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


    private Assignment2() {
        setTitle("Assignment 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        newRoad.setPreferredSize(new Dimension(100, 40));
        editMode.setPreferredSize(new Dimension(100, 40));
        runMode.setPreferredSize(new Dimension(100, 40));
        startRun.setPreferredSize(new Dimension(100, 40));
        saveRoads.setPreferredSize(new Dimension(100, 40));


        add(newRoad, "West");
        add(editMode, "East");
        add(runMode, "North");
        add(startRun, "South");
        JLabel output = new JLabel();
        add(output, "Center");
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

            System.out.println("Crossroad list: " + crossroadList);
            int numberOfCrossroads = crossroadList.size();
            Random randomSpawns = new Random();
            int chanceOfSpawning = randomSpawns.nextInt(11);
            if (chanceOfSpawning > 0) {
                int spawnOptions = randomSpawns.nextInt(numberOfCrossroads + 1);
                for (int spawnLocation = 0; spawnLocation < uniqueSpawnList.size(); spawnLocation++) {
                    if (spawnLocation == spawnOptions) {
                        Car car = new Car(10, 10, uniqueSpawnList.get(spawnLocation).getStartXPosition(), uniqueSpawnList.get(spawnLocation).getStartYPosition(), 1, carID);
                        carID += 1;
                        for (Car value : cars) {
                            if (value.getyPosition() <= 0) {
                                car.setSpeed(0.1);
                                car.driveY();
                            } else if (value.getxPosition() >= 500) {
                                car.setSpeed(-0.1);
                                car.driveY();
                            } else if (value.getxPosition() <= 0) {
                                car.setSpeed(0.1);
                                car.driveY();
                            } else if (value.getyPosition() >= 500) {
                                car.setSpeed(-0.1);
                                car.driveX();
                            }

                        }
                    }
                }

            }
            for (Car car : cars) {
                System.out.println("Car x position is: " + car.getxPosition());
            }
            System.out.println("Unique spawn list is: " + uniqueSpawnList);
            System.out.println("FROM ASSIGNMENT 2");
            for (Road road : roads) {
                System.out.println("Start X: " + road.getStartXPosition());
                System.out.println("Start Y: " + road.getStartYPosition());
                System.out.println("End X: " + road.getXFinish());
                System.out.println("End Y: " + road.getYFinish());


            }

        } else {
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
            System.out.println(drawnRoad.getStartXPosition() + " + " + drawnRoad.getStartYPosition() + " + " + drawnRoad.getXFinish() + " + " + drawnRoad.getStartYPosition());
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
                    if ((selectedRoad.getStartXPosition() <= currentRoad.getStartXPosition()) && (selectedRoad.getXFinish() >= currentRoad.getStartXPosition())) {
                        yIntersect = selectedRoad.getStartYPosition();
                        xIntersect = currentRoad.getStartXPosition();
                        Crossroads crossroads = new Crossroads(xIntersect, yIntersect);
                        crossroadList.add(crossroads);
                    } else if (selectedRoad.getStartYPosition() <= currentRoad.getStartYPosition() && selectedRoad.getYFinish() >= currentRoad.getStartYPosition()) {
                        yIntersect = currentRoad.getStartYPosition();
                        xIntersect = selectedRoad.getStartXPosition();
                        Crossroads crossroads = new Crossroads(xIntersect, yIntersect);
                        crossroadList.add(crossroads);
                    } else if ((selectedRoad.getStartXPosition() >= currentRoad.getStartXPosition()) && (selectedRoad.getXFinish() <= currentRoad.getStartXPosition())) {
                        yIntersect = selectedRoad.getStartYPosition();
                        xIntersect = currentRoad.getStartXPosition();
                        Crossroads crossroads = new Crossroads(xIntersect, yIntersect);
                        crossroadList.add(crossroads);
                    } else if (selectedRoad.getStartYPosition() <= currentRoad.getStartYPosition() && selectedRoad.getYFinish() >= currentRoad.getStartYPosition()) {
                        yIntersect = currentRoad.getStartYPosition();
                        xIntersect = selectedRoad.getStartXPosition();
                        Crossroads crossroads = new Crossroads(xIntersect, yIntersect);
                        crossroadList.add(crossroads);
                    }
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.blue);
        for (Car car : cars) {
            g.drawRect(car.getyPosition(), car.getxPosition(), 10, 10);
        }

    }


}
