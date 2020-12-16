import javax.swing.*;
import java.awt.Color;

public abstract class Piece {
    Color color;
    int xPosition;
    int yPosition;
    String directory;

    Piece(int x, int y, Color c, String dir) {
        xPosition = x;
        yPosition = y;
        color = c;
        directory = dir;
    }

    public Color getColor() {
        return color;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public String getDir() {
        return directory;
    }

    public boolean validMove(Board board, Square startSQ, Square endSQ) {
        return true;
    }
    // Move, setColor, getColor, getPosition, setPosition
}