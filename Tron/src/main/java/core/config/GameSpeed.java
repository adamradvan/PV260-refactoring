package core.config;

public enum GameSpeed {
    SLOW(70),
    MEDIUM(50),
    FAST(30);

    private final int milliseconds;

    GameSpeed(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int milliseconds() {
        return milliseconds;
    }
}
