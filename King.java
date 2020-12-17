import java.awt.Color;

public class King extends Piece {

    King(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
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
