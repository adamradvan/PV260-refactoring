package generalEngine;

public class Controls {
    private final int up;
    private final int down;
    private final int right;
    private final int left;

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
}
