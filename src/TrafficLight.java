public class TrafficLight {

    public TrafficLight(boolean isXGreen, boolean isYGreen){
        this.isXGreen = isXGreen;
        this.isYGreen = isYGreen;

    }



    private boolean isXGreen;
    private boolean isYGreen;


    boolean isXGreen() {
        return isXGreen;
    }

    public void setXGreen(boolean XGreen) {
        isXGreen = XGreen;
    }

    boolean isYGreen() {
        return isYGreen;
    }

    public void setYGreen(boolean YGreen) {
        isYGreen = YGreen;
    }

    void changeX(){
        if (isXGreen()){
            isXGreen = false;
            System.out.println("X direction is now Red\nY direction is now Green");
        }
        else{
            isXGreen = true;
            System.out.println("X direction is now Green\nY direction is now Red");
        }

    }

    void changeY(){
        if (isYGreen()){
            isYGreen = false;
            System.out.println("X direction is now Red\nY direction is now Green");
        }
        else{
            isYGreen = true;
            System.out.println("X direction is now Green\nY direction is now Red");
        }

    }

}
