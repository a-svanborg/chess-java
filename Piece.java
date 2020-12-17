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

    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        return true;
    }
}