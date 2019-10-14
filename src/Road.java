public class Road {



    public Road(int startXPosition, int startYPosition, int length, int height, String roadID){
        this.startXPosition = startXPosition;
        this.startYPosition = startYPosition;
        this.height = height;
        this.length = length;
        this.roadID = roadID;

    }

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

    private int length;
    private int height;

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
        return startXPosition + length;
    }
    public int getYFinish(){
        return startYPosition + height;
    }
}
