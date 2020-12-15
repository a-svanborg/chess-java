import javax.swing.*;
import java.awt.Color;

public class Square extends JButton{
    // Has a position and a may have a piece
    private int xPosition;
    private int yPosition;
    private Piece piece;

    public Square(int xPosition, int yPosition, Piece piece) {
        setSize(100,100);
        setBorder(BorderFactory.createLineBorder(Color.decode("#00A4CCFF"),10,false));
        setBorderPainted(true);
        setContentAreaFilled(true);
        
        setBackground(Color.decode("#00203FFF"));
        setForeground(Color.BLACK);
        setOpaque(true);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public int getX(){
        return this.xPosition;
    }

    public int getY(){
        return this.yPosition;
    }

    public void setX(int x){
        this.xPosition = x;
    }

    public void setY(int y){
        this.yPosition = y;
    }

    public boolean occupied() {
        return (this.piece != null);
    }
}
