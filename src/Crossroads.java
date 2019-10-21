
public class Crossroads {
    Crossroads(int xIntercept, int yIntercept) {
        this.xIntercept = xIntercept;
        this.yIntercept = yIntercept;
    }

    private int xIntercept;
    private int yIntercept;
    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;

    public int getxIntercept() {
        return xIntercept;
    }

    public void setxIntercept(int xIntercept) {
        this.xIntercept = xIntercept;
    }

    public int getyIntercept() {
        return yIntercept;
    }

    public void setyIntercept(int yIntercept) {
        this.yIntercept = yIntercept;
    }


}
