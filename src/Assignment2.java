import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Assignment2 extends JFrame implements ActionListener{
    private JButton newRoad = new JButton("Add Road");
    private JButton editMode = new JButton("Edit mode");
    private  JButton runMode = new JButton("Run mode");
    private JButton startRun = new JButton("Start simulation");
    private JButton saveRoads = new JButton("Save Roads");
    private JFrame addingRoads = new JFrame("Roads");
    private JLabel output = new JLabel();
    private int clickNumber = 1;
    private int startRoadX;
    private int startRoadY;
    private int endRoadX;
    private int endRoadY;
    private RoadEditorPanel roadEditorPanel = new RoadEditorPanel();

    public class RoadEditorPanel extends JFrame {
        RoadEditorPanel(){
            super("Road Editor");
            setSize(600, 600);
            JPanel roadEditorPanel = new JPanel();
            roadEditorPanel.setLayout(new BorderLayout());
            roadEditorPanel.setSize(500, 500);
            roadEditorPanel.setBackground(Color.WHITE);
            JButton saveEditedRoads = new JButton("Save Roads");
            add(saveEditedRoads, "North");
            saveEditedRoads.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    setVisible(false);
                    clickNumber = 1;
                }
            });
            roadEditorPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(isVisible()){
                        {
                            if(clickNumber == 1){
                                startRoadX = e.getX();
                                startRoadY = e.getY();
                                System.out.println("Click one is at " + startRoadX + ", " + startRoadY);
                            }
                            if(clickNumber == 2){
                                endRoadX = e.getX();
                                endRoadY = e.getY();

                                System.out.println("Click two is at " + endRoadX + ", " + endRoadY);
                            }
                            if(clickNumber >= 2){
                                clickNumber = 0;
                            }
                            clickNumber +=1;




                        }
                    }
                }
            });
            add(roadEditorPanel);

            boolean isVertical = Math.abs(startRoadX - endRoadX) > Math.abs(startRoadY = endRoadY);

            if(isVertical){
                Road road = new Road(startRoadX, startRoadY, Math.abs(startRoadX - endRoadX), 3, "1");
            }
            else{
                Road road = new Road(startRoadX, startRoadY,3 ,  Math.abs(startRoadY - endRoadY), "1");
            }


        }


    }

    private Assignment2(){
        setTitle("Assignment 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(newRoad, "West");
        add(editMode, "East");
        add(runMode, "North");
        add(startRun, "South");
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


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        output.setSize(500, 500);
        output.add(new JLabel("Please work"));

        if(source == editMode){
            runMode.setVisible(false);
            newRoad.setVisible(true);
            saveRoads.setVisible(true);
            System.out.println("Pressed edit mode");

        }
        else if(source == newRoad){
            roadEditorPanel.setVisible(true);
            output.add(new JLabel("Bazinga"));
            System.out.println("Pressed new road");

        }
        else if(source == saveRoads){
            startRun.setVisible(true);
            runMode.setVisible(true);
            newRoad.setVisible(false);
            saveRoads.setVisible(false);
            output.add(new JLabel("Kachow"));
            System.out.println("Pressed save roads");
        }


        else{
            runMode.setVisible(false);
            newRoad.setVisible(false);
        }
    }




    public static void main (String[] args){
        Assignment2 assignment2 = new Assignment2();
        assignment2.setSize(800, 800);
        assignment2.setVisible(true);

    }


}
