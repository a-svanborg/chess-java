import java.awt.Color;

import javax.swing.ImageIcon;

public class Queen extends Piece {

    Queen(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Currently moves like king which is ok for grade E
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        if (endP.color == startP.color) { 
            return false; 
        }

        int x = Math.abs(startP.xPosition - endP.xPosition); 
        int y = Math.abs(startP.yPosition - endP.yPosition);

        if (x + y == 1 || (x==1 && y==1)) { 
            return true;
        }
        return false;
    }
}
