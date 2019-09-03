public class Road {

    public Road(int length, int height, int startXPosition, int startYPosition, String roadID){
        this.length = length;
        this.height = height;
        this.startXPosition = startXPosition;
        this.startYPosition = startYPosition;
        this.roadID = roadID;

    }

    private int length;
    private int height;
    private int startXPosition;
    private int startYPosition;



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRoadID() {
        return roadID;
    }

    public void setRoadID(String roadID) {
        this.roadID = roadID;
    }

    private String roadID;

    public int getStartXPosition() {
        return startXPosition;
    }

    public void setStartXPosition(int startXPosition) {
        this.startXPosition = startXPosition;
    }

    public int getStartYPosition() {
        return startYPosition;
    }

    public void setStartYPosition(int startYPosition) {
        this.startYPosition = startYPosition;
    }

    public int getXFinish(){
        return (getStartXPosition() + length);
    }

    public int getYFinish(){
        return (getStartYPosition() + height);
    }

}
