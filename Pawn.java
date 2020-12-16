import java.awt.Color;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

    Pawn(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
        // TODO Auto-generated constructor stub
    }
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {

        if (startP != null && endP != null && startP.color == endP.color) {
            return false;
        }

        int x = Math.abs(startP.xPosition - endP.xPosition); 
        int y = Math.abs(startP.yPosition - endP.yPosition);

        if (x + y == 1) { 
            return true; 
        }

        return true;
    }
}
