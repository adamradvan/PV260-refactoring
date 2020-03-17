package tron;

public class Position {
    private int axisX;
    private int axisY;

    public Position (int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }
    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }
    
    
}
