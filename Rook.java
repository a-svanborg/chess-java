import java.awt.Color;

public class Rook extends Piece {

    Rook(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        if (endP.getColor() == startP.getColor()) { 
            return false; 
        }
        int x = Math.abs(startP.getX() - endP.getX()); 
        int y = Math.abs(startP.getY() - endP.getY());

        if (startP.getX() == endP.getX()) {
            //Left
            if (startP.getY() > endP.getY()) {
                //Loop through all squares between.
                for (int i = 1; i < y; i++) {
                    Piece currentSquare = board[startP.getX()][startP.getY() - i];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
                }
            //Right
            } else {
                for (int i = 1; i < y; i++) {
                    Piece currentSquare = board[startP.getX()][startP.getY() + i];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
                }
            }
        } else if (startP.getY() == endP.getY()) {
            //Down
            if (startP.getX() < endP.getX()) {
                //Loop through all squares between.
                for (int i = 1; i < x; i++) {
                    Piece currentSquare = board[startP.getX() + i][startP.getY()];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
                }
            //Up
            } else {
                for (int i = 1; i < x; i++) {
                    Piece currentSquare = board[startP.getX() - i][startP.getY()];
                    if (currentSquare.getColor() != Color.BLUE) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
