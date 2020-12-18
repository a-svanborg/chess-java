import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public abstract class Piece {
    public Color color;
    public boolean inStrike = false;
    public boolean hasMoved = false;
    public boolean isChecking = false;
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

    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        return true;
    }


}