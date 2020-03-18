package tron;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class ScreenManager {

    private GraphicsDevice screen;

    public ScreenManager() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        screen = graphicsEnvironment.getDefaultScreenDevice();
    }

    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {
        DisplayMode[] goodModes = screen.getDisplayModes();
        for (DisplayMode mode : modes) {
            for (DisplayMode goodMode : goodModes) {
                if (displayModesMatch(mode, goodMode)) {
                    return mode;
                }
            }
        }
        return null;
    }

    public boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2) {
        if (mode1.getWidth() != mode2.getWidth() || mode1.getHeight() != mode2.getHeight()) {
            return false;
        }
        if (mode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode1.getBitDepth() != mode2.getBitDepth()) {
            return false;
        }
        return mode1.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || mode2.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || mode1.getRefreshRate() == mode2.getRefreshRate();
    }

    public void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);

        screen.setFullScreenWindow(frame);

        if (displayMode != null && screen.isDisplayChangeSupported()) {
            try {
                screen.setDisplayMode(displayMode);
            } catch (Exception ignored) {
            }

            frame.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window window = screen.getFullScreenWindow();
        if (window != null) {
            BufferStrategy buffer = window.getBufferStrategy();
            return (Graphics2D) buffer.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window window = screen.getFullScreenWindow();
        if (window != null) {
            BufferStrategy buffer = window.getBufferStrategy();
            if (!buffer.contentsLost()) {
                buffer.show();
            }
        }
    }

    public void restoreScreen() {
        Window window = screen.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        screen.setFullScreenWindow(null);
    }


    public Window getFullScreenWindow() {
        return screen.getFullScreenWindow();
    }

    public int getWidth() {
        Window window = screen.getFullScreenWindow();
        if (window != null) {
            return window.getWidth();
        } else {
            return 0;
        }
    }

    public int getHeight() {
        Window window = screen.getFullScreenWindow();
        if (window != null) {
            return window.getHeight();
        } else {
            return 0;
        }
    }

}
