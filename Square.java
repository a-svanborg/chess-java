import javax.swing.*;
import java.awt.Color;

public class Square extends JButton{
    // Has a position, color and  a piece. If the square is "empty", it holds a mock-piece which is blue.
    int xPosition;
    int yPosition;
    Piece piece;
    Color color;

    public Square(int xPosition, int yPosition, Piece piece, Color c) {
        color = c;
        setSize(100,100);
        setBorder(BorderFactory.createLineBorder(Color.decode("#00A4CCFF"),2,false));
        setBorderPainted(true);
        setContentAreaFilled(true);
        
        setBackground(color);
        setForeground(Color.BLACK);
        setOpaque(true);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.piece = piece;
    }
}
