import javax.swing.*;
import java.awt.Color;

public class Square extends JButton{
    // Has a position, color and  a piece. If the square is "empty", it holds a mock-piece which is blue.
    private int xPosition;
    private int yPosition;
    private Piece Piece;
    private Color color;

    public Square(int x, int y, Piece piece, Color c) {
        color = c;
        setSize(100,100);
        setBorder(BorderFactory.createLineBorder(Color.decode("#00A4CCFF"),2,false));
        setBorderPainted(true);
        setContentAreaFilled(true);
        
        setBackground(color);
        setForeground(Color.BLACK);
        setOpaque(true);
        xPosition = x;
        yPosition = y;
        Piece = piece;
    }

    public int getXpos() {
        return xPosition;
    }

    public int getYpos() {
        return yPosition;
    }

    public Piece getPiece() {
        return Piece;
    }

    public void setX(int x) {
        xPosition = x;
    }

    public void setY(int y) {
        yPosition = y;
    }
}
