public class Car {

    static void main (String[] argss){
    }

    public Car(int length, int width, int xPosition, int yPosition, int speed){
        this.length = length;
        this.width = width;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = speed;
    }



    private int xPosition;
    private int yPosition;
    private int length;
    private int width;
    private int speed = 1;



    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


  int driveY(){
        yPosition += speed;
        return yPosition;
  }

  int driveX(){
        xPosition += speed;
        return xPosition;
  }

  int stopX(){
        return xPosition;
  }

  int stopY(){
        return yPosition;
  }


}
