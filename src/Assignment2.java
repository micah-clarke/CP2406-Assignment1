import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Assignment2 extends JFrame implements ActionListener{
    private JButton newRoad = new JButton("Add Road");
    private JButton editMode = new JButton("Edit mode");
    private  JButton runMode = new JButton("Run mode");
    private JButton startRun = new JButton("Start simulation");
    private JButton saveRoads = new JButton("Save Roads");
    private JFrame addingRoads = new JFrame("Roads");
    private static JPanel allOfTheRoads = new JPanel();
    private JLabel output = new JLabel();
    private static DrawRoad drawRoad = new DrawRoad();

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
        drawRoad.setVisible(false);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        output.setSize(500, 500);
        allOfTheRoads.setSize(500,500);
        add(allOfTheRoads, "Center");

        output.add(new JLabel("Please work"));

        if(source == editMode){
            runMode.setVisible(false);
            newRoad.setVisible(true);
            saveRoads.setVisible(true);
            System.out.println("Pressed edit mode");

        }
        else if(source == newRoad){

            drawRoad.setVisible(true);
            System.out.println("1 start x " + drawRoad.getPointStartX() + " Start y " + drawRoad.getPointStartY() + " end x " + drawRoad.getFinalEndX() + " end y "+ drawRoad.getFinalEndY());
            System.out.println(drawRoad.getPointStartX()+ drawRoad.getPointStartY()+ drawRoad.getFinalEndX()+ drawRoad.getFinalEndY());
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

    static void reDraw()
    {
        allOfTheRoads.getGraphics().drawLine(drawRoad.getPointStartX(), drawRoad.getPointStartY(), drawRoad.getFinalEndX(), drawRoad.getFinalEndY());
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
    }

    public static void main (String[] args){
        Assignment2 assignment2 = new Assignment2();
        assignment2.setSize(800, 800);
        assignment2.setVisible(true);

    }


}
