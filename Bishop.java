import java.awt.Color;

public class Bishop extends Piece {

    Bishop(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Currently moves like king which is ok for grade E
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        if (endP.getColor() == startP.getColor()) { 
            return false; 
        }

        int x = Math.abs(startP.getX() - endP.getX()); 
        int y = Math.abs(startP.getY() - endP.getY());

        // Check if diagonal
        if (x != y) { 
            return false;
        }

        // Up right
        if (startP.getX() > endP.getX() && startP.getY() < endP.getY()) {
            for (int i = 1; i < x; i++) {
                Piece currentSquare = board[startP.getX() - i][startP.getY() + i];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
            }
        // down left
        } else if (startP.getX() < endP.getX() && startP.getY() > endP.getY()) {
            for (int i = 1; i < x; i++) {
                Piece currentSquare = board[startP.getX() + i][startP.getY() - i];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
            }
        // up left
        } else if (startP.getX() > endP.getX() && startP.getY() > endP.getY()) {
            for (int i = 1; i < x; i++) {
                Piece currentSquare = board[startP.getX() - i][startP.getY() - i];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
            }
        // down right
        } else {
            for (int i = 1; i < x; i++) {
                Piece currentSquare = board[startP.getX() + i][startP.getY() + i];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
            }
        }
        return true;
    }
}
