import java.awt.Color;
public abstract class Piece {
    private Color color;
    boolean inStrike = false;
    boolean isChecking = false;
    boolean hasMoved = false;
    private int xPosition;
    private int yPosition;
    private String directory;

    Piece(int x, int y, Color c, String dir) {
        xPosition = x;
        yPosition = y;
        color = c;
        directory = dir;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public void setX(int x) {
        xPosition = x;
    }

    public void setY(int y) {
        yPosition = y;
    }

    public String getDir() {
        return directory;
    }

    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        return true;
    }
}