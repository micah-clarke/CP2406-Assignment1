import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class Assignment2 extends JFrame implements ActionListener, MouseListener {
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

    public class RoadEditor extends JPanel {
        RoadEditor(){
            this.setPreferredSize(new Dimension(500, 500));
            this.add(new JLabel("Hello test whatever"));
        }
    }

    public Assignment2(){
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



        if(source == editMode){
            runMode.setVisible(false);
            newRoad.setVisible(true);
            saveRoads.setVisible(true);
            if(source == newRoad){
                RoadEditor roadEditor = new RoadEditor();
                roadEditor.setVisible(true);


            }
        }
        else if(source == saveRoads){
            startRun.setVisible(true);
            runMode.setVisible(true);
            newRoad.setVisible(false);
            saveRoads.setVisible(false);
        }


        else{
            runMode.setVisible(false);
            newRoad.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if(clickNumber == 1){
                startRoadX = e.getX();
                startRoadY = e.getY();
                clickNumber = 2;
            }
            if(clickNumber == 2){
                endRoadX = e.getX();
                endRoadY = e.getY();
                clickNumber = 1;
            }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


    public static void main (String[] args){
        Assignment2 assignment2 = new Assignment2();
        assignment2.setSize(800, 800);
        assignment2.setVisible(true);

    }


}
