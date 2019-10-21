import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DrawRoad extends JFrame {

    private static int pointStartX;
    private static int pointEndX;
    private static int pointStartY;
    private static int pointEndY;
    private static int finalEndY;
    private static int finalEndX;
    private int roadID = 0;
    private boolean verticalStatus;

    DrawRoad() {

        setSize(500, 500);
        setResizable(false);


        JPanel p = new JPanel() {


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
                        int length = finalEndX - pointStartX;
                        int height = finalEndY - pointStartY;
                        Road road = new Road(pointStartX, pointStartY, length, height, roadID);
                        Assignment2.roads.add(road);
                        roadID += 1;
                        setInvisible();
                        System.out.println("1 start x " + pointStartX + " Start y " + pointStartY + " end x " + finalEndX + " end y " + finalEndY);
                        for (int i = 0; i < Assignment2.roads.size(); ++i) {
                            Road drawnRoad = Assignment2.roads.get(i);
                            getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                        }

                    }
                });
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {

                        pointStartX = (e.getX() % 10 == 0) ? e.getX() : ((e.getX() / 10 + 1) * 10);
                        pointStartY = (e.getY() % 10 == 0) ? e.getY() : ((e.getY() / 10 + 1) * 10);
                        if (pointStartX > 500) {
                            pointStartX = 500;
                        } else if (pointStartY > 500) {
                            pointStartY = 500;
                        } else if (pointStartX < 0) {
                            pointStartX = 0;
                        } else if (pointStartY < 0) {
                            pointStartY = 0;
                        }
                        for (int i = 0; i < Assignment2.roads.size(); ++i) {
                            Road drawnRoad = Assignment2.roads.get(i);
                            getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                        }


                    }
                });
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e);
                        finalEndY = (e.getY() % 10 == 0) ? e.getY() : ((e.getY() / 10 + 1) * 10);
                        finalEndX = (e.getX() % 10 == 0) ? e.getX() : ((e.getX() / 10 + 1) * 10);
                        if (finalEndX > 500) {
                            finalEndX = 500;
                        } else if (finalEndY > 500) {
                            finalEndY = 500;
                        } else if (pointStartX < 0) {
                            pointStartX = 0;
                        } else if (pointStartY < 0) {
                            pointStartY = 0;
                        }
                        for (int i = 0; i < Assignment2.roads.size(); ++i) {
                            Road drawnRoad = Assignment2.roads.get(i);
                            getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                        }
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent e) {
//                        pointEndX = e.getX();
//                        pointEndY = e.getY();

                        int xDifference = pointEndX - e.getX();
                        int yDifference = pointEndY - e.getY();
                        if (java.lang.Math.abs(xDifference) > java.lang.Math.abs(yDifference)) {
                            pointEndY = pointStartY;
//                            System.out.println("2 start x " + pointStartX + " Start y " + pointStartY + " end x " + pointEndX + " end y "+ pointEndY);
                        } else if ((java.lang.Math.abs(xDifference) < java.lang.Math.abs(yDifference))) {
                            pointEndX = pointStartX;
//                            System.out.println("3 start x " + pointStartX + " Start y " + pointStartY + " end x " + pointEndX + " end y "+ pointEndY);
                        }
                        for (int i = 0; i < Assignment2.roads.size(); ++i) {
                            Road drawnRoad = Assignment2.roads.get(i);
                            getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                        }
                    }

                    public void mouseDragged(MouseEvent e) {
                        pointEndX = e.getX();
                        pointEndY = e.getY();
                        if (pointEndX > 500) {
                            pointEndX = 500;
                        } else if (pointEndY > 500) {
                            pointEndY = 500;
                        } else if (pointStartX < 0) {
                            pointStartX = 0;
                        } else if (pointStartY < 0) {
                            pointStartY = 0;
                        }
                        repaint();
                        addRoad.setVisible(true);
                        for (int i = 0; i < Assignment2.roads.size(); ++i) {
                            Road drawnRoad = Assignment2.roads.get(i);
                            getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                        }

                    }

                });

            }

            void isVertical() {
                int totalDifferenceX = finalEndX - pointStartX;
                int totalDifferenceY = finalEndY - pointStartY;
                if (Math.abs(totalDifferenceX) > (Math.abs(totalDifferenceY))) {
                    finalEndY = pointStartY;
                    verticalStatus = true;
                } else {
                    finalEndX = pointStartX;
                    verticalStatus = false;
                }
                for (int i = 0; i < Assignment2.roads.size(); ++i) {
                    Road drawnRoad = Assignment2.roads.get(i);
                    getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                }
            }

            public void paint(Graphics g) {
                super.paint(g);
                int xDifference = pointEndX - pointStartX;
                int yDifference = pointEndY - pointStartY;
                if (Math.abs(xDifference) > Math.abs(yDifference)) {
                    pointEndY = pointStartY;
                    g.setColor(Color.red);
                    g.drawLine(pointStartX, pointStartY, pointEndX,
                            pointEndY);


                } else if ((Math.abs(xDifference) < Math.abs(yDifference))) {
                    pointEndX = pointStartX;
                    g.setColor(Color.red);
                    g.drawLine(pointStartX, pointStartY, pointEndX,
                            pointEndY);
                }
                for (int i = 0; i < Assignment2.roads.size(); ++i) {
                    Road drawnRoad = Assignment2.roads.get(i);
                    getGraphics().drawLine(drawnRoad.getStartXPosition(), drawnRoad.getStartYPosition(),drawnRoad.getXFinish(), drawnRoad.getYFinish());
                }

            }
        };
        add(p);
        setVisible(true);

    }

    private void setInvisible() {
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