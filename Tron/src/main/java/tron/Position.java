package main.java.tron;

public class Position {
    private int axisX;
    private int axisY;

    public Position(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }
    
    public boolean equals(Position position) {
        if (this == position) {
            return true;
        }
        
        if ( position == null) {
            return false;
        }
                       
        return this.axisX == position.getAxisX() &&
               this.axisY == position.getAxisY();
        }
}
