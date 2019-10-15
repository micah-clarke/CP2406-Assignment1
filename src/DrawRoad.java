import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DrawRoad extends JFrame {

    private static int pointStartX = 0x0;
    private static int pointEndX = 0x0;
    private static int pointStartY = 0x0;
    private static int pointEndY = 0x0;
    private static int finalEndY;
    private static int finalEndX;

    DrawRoad() {

        setSize(500, 500);
        setResizable(false);

        JPanel p = new JPanel(){

            {
                JButton addRoad = new JButton("Add Road");
                add(addRoad, "North");
                addRoad.setVisible(false);
                addRoad.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        isVertical();
                        getGraphics().drawLine(pointStartX, pointStartY, finalEndX, finalEndY);
                        Assignment2.reDraw();

                        setInvisible();
                        System.out.println(this);
//                        System.out.println("1 start x " + pointStartX + " Start y " + pointStartY + " end x " + pointEndX + " end y "+ pointEndY);

                    }
                });
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        pointStartX = e.getX();
                        pointStartY = e.getY();

                    }
                });
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e);
                        finalEndY = e.getY();
                        finalEndX = e.getX();
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent e) {
//                        pointEndX = e.getX();
//                        pointEndY = e.getY();

                        int xDifference = pointEndX - e.getX();
                        int yDifference = pointEndY - e.getY();
                        if(java.lang.Math.abs(xDifference)> java.lang.Math.abs(yDifference)){
                            pointEndY = pointStartY;
//                            System.out.println("2 start x " + pointStartX + " Start y " + pointStartY + " end x " + pointEndX + " end y "+ pointEndY);
                        }
                        else if((java.lang.Math.abs(xDifference)< java.lang.Math.abs(yDifference))){
                            pointEndX = pointStartX;
//                            System.out.println("3 start x " + pointStartX + " Start y " + pointStartY + " end x " + pointEndX + " end y "+ pointEndY);
                        }
                    }

                    public void mouseDragged(MouseEvent e) {
                        pointEndX = e.getX();
                        pointEndY = e.getY();
                        repaint();
                        addRoad.setVisible(true);
                    }
                });
            }

            void isVertical(){
                int totalDifferenceX = finalEndX - pointStartX;
                int totalDifferenceY = finalEndY - pointStartY;
                if(Math.abs(totalDifferenceX) > (Math.abs(totalDifferenceY))){
                    finalEndY = pointStartY;
                }
                else{
                    finalEndX = pointStartX;
                }

            }

            public void paint(Graphics g) {
                super.paint(g);
                if (pointStartX != 0x0) {
                    int xDifference = pointEndX - pointStartX;
                    int yDifference = pointEndY - pointStartY;
                    if(java.lang.Math.abs(xDifference)> java.lang.Math.abs(yDifference)){
                        pointEndY = pointStartY;
                        g.setColor(Color.red);
                        g.drawLine(pointStartX, pointStartY, pointEndX,
                                pointEndY);


                    }
                    else if((java.lang.Math.abs(xDifference)< java.lang.Math.abs(yDifference))){
                        pointEndX = pointStartX;
                        g.setColor(Color.red);
                        g.drawLine(pointStartX, pointStartY, pointEndX,
                                pointEndY);
                    }

                }
            }
        };
        add(p);
        setVisible(true);
    }

    private void setInvisible(){
        setVisible(false);
    }


    int getPointStartX() {
        return pointStartX;
    }

    int getPointStartY() {
        return pointStartY;
    }

    int getFinalEndY() {
        return finalEndY;
    }

    int getFinalEndX() {
        return finalEndX;
    }
}