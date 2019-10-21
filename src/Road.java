public class Road {



    public Road(int startXPosition, int startYPosition, int length, int height, int roadID){
        this.startXPosition = startXPosition;
        this.startYPosition = startYPosition;
        this.height = height;
        this.length = length;

    }

    private int startXPosition;
    private int startYPosition;

    int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int length;
    private int height;

    String getRoadID() {
        return roadID;
    }

    public void setRoadID(String roadID) {
        this.roadID = roadID;
    }

    private String roadID;

    int getStartXPosition() {
        return startXPosition;
    }

    public void setStartXPosition(int startXPosition) {
        this.startXPosition = startXPosition;
    }

    int getStartYPosition() {
        return startYPosition;
    }

    public void setStartYPosition(int startYPosition) {
        this.startYPosition = startYPosition;
    }

    int getXFinish(){
        return startXPosition + length;
    }
    int getYFinish(){
        return startYPosition + height;
    }

}
