package tron;

public class Controls {
    private int up;
    private int down;
    private int right;
    private int left;
    
    public Controls(int up, int down, int right, int left) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}
