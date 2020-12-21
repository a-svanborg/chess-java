import java.awt.Color;

public class Knight extends Piece {

    Knight(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Returns true if the move is ok
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {

        if (endP.getColor() == startP.getColor()) { 
            return false; 
        }

        int x = Math.abs(startP.getX() - endP.getX()); 
        int y = Math.abs(startP.getY() - endP.getY()); 
        
        if (x * y == 2) {
            return true;
       }
       return false;
    }
}
