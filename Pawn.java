import java.awt.Color;

public class Pawn extends Piece {
    private boolean hasMoved = false;

    Pawn(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Returns true if the move is ok
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {

        if (endP.color == startP.color) { 
            return false; 
        }
        if (hasMoved == false) {
            if (startP.color == Color.WHITE) {
                // First move = 1 or 2 steps "forward"
                if (startP.yPosition == endP.yPosition && ((endP.xPosition - startP.xPosition == -2) || (endP.xPosition - startP.xPosition == -1)) && endP.color == Color.BLUE) {
                    hasMoved = true;
                    return true;
                
                // Capturing
                } else if (endP.color == Color.BLACK && endP.xPosition - startP.xPosition == -1 && Math.abs(endP.yPosition - startP.yPosition) == 1) {
                    return true;
                }
            } else {
                // First move = 1 or 2 steps "forward"
                if (startP.yPosition == endP.yPosition && ((startP.xPosition - endP.xPosition == -2) || (startP.xPosition - endP.xPosition == -1) && endP.color == Color.BLUE)) {
                    hasMoved = true;
                    return true;
                
                // Capturing
                } else if (endP.color == Color.WHITE && endP.xPosition - startP.xPosition == 1 && Math.abs(endP.yPosition - startP.yPosition) == 1) {
                    return true;
                }
            }
            
        } else {
            if (startP.color == Color.WHITE) {
                //Single forward
                if (startP.yPosition == endP.yPosition && (endP.xPosition - startP.xPosition == -1) && endP.color == Color.BLUE) {
                    return true;
                //Capturing
                } else if (endP.color == Color.BLACK && endP.xPosition - startP.xPosition == -1 && Math.abs(endP.yPosition - startP.yPosition) == 1) {
                    return true;
                }
            } else {
                // Single forward
                if (startP.yPosition == endP.yPosition && (startP.xPosition - endP.xPosition == -1) && endP.color == Color.BLUE) {
                    return true;
                // Capturing
                } else if (endP.color == Color.WHITE && endP.xPosition - startP.xPosition == 1 && Math.abs(endP.yPosition - startP.yPosition) == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
