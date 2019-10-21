public class Car {

    public Car(int length, int width, int xPosition, int yPosition, double speed, int carID){
        this.length = length;
        this.width = width;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = speed;
        this.carID = carID;
    }



    private int xPosition;
    private int yPosition;
    private int length;
    private int width;
    private double speed = 1;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    private int carID;



    int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    double getSpeed() {
        return speed;
    }

    void setSpeed(double speed) {
        this.speed = speed;
    }


  void driveY(){
        yPosition += speed;
  }

  void driveX(){
        xPosition += speed;
  }

  void stopX(){
  }

  int stopY(){
        return yPosition;
  }


}
