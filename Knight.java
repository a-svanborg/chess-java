import java.awt.Color;

import javax.swing.ImageIcon;

public class Knight extends Piece {

    Knight(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
        // TODO Auto-generated constructor stub
    }

    // Returns true if the move is ok
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
