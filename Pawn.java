import java.awt.Color;

public class Pawn extends Piece {
    

    Pawn(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Returns true if the move is ok
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {

        if (endP.getColor() == startP.getColor()) { 
            return false; 
        }
        
        if (hasMoved == false) {
            if (startP.getColor() == Color.WHITE) {
                // First move = 1 or 2 steps "forward"
                if (startP.getY() == endP.getY() && ((endP.getX() - startP.getX() == -2) || (endP.getX() - startP.getX() == -1)) && endP.getColor() == Color.BLUE && board[startP.getX() - 1][startP.getY()].getColor() == Color.BLUE) {
                    return true;
                
                // Capturing
                } else if (endP.getColor() == Color.BLACK && endP.getX() - startP.getX() == -1 && Math.abs(endP.getY() - startP.getY()) == 1) {
                    return true;
                }
            } else {
                // First move = 1 or 2 steps "forward"
                if (startP.getY() == endP.getY() && ((startP.getX() - endP.getX() == -2) || (startP.getX() - endP.getX() == -1) && endP.getColor() == Color.BLUE) && board[startP.getX() + 1][startP.getY()].getColor() == Color.BLUE) {
                    return true;
                
                // Capturing
                } else if (endP.getColor() == Color.WHITE && endP.getX() - startP.getX() == 1 && Math.abs(endP.getY() - startP.getY()) == 1) {
                    return true;
                }
            }
            
        } else {
            if (startP.getColor() == Color.WHITE) {
                //Single forward
                if (startP.getY() == endP.getY() && (endP.getX() - startP.getX() == -1) && endP.getColor() == Color.BLUE) {
                    return true;
                //Capturing
                } else if (endP.getColor() == Color.BLACK && endP.getX() - startP.getX() == -1 && Math.abs(endP.getY() - startP.getY()) == 1) {
                    return true;
                }
            } else {
                // Single forward
                if (startP.getY() == endP.getY() && (startP.getX() - endP.getX() == -1) && endP.getColor() == Color.BLUE) {
                    return true;
                // Capturing
                } else if (endP.getColor() == Color.WHITE && endP.getX() - startP.getX() == 1 && Math.abs(endP.getY() - startP.getY()) == 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
