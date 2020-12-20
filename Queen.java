import java.awt.Color;

public class Queen extends Piece {

    Queen(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Currently moves like king which is ok for grade E
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        if (endP.getColor() == startP.getColor()) { 
            return false; 
        }

        int x = Math.abs(startP.getX() - endP.getX()); 
        int y = Math.abs(startP.getY() - endP.getY());

        if (x + y == 1 || (x==1 && y==1)) { 
            return true;
        }

        if (x != y && !(startP.getX() == endP.getX() || startP.getY() == endP.getY())) { 
            return false;
        }

        // Check horizontal and vertical
        if (startP.getX() == endP.getX() || startP.getY() == endP.getY()) {
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
        }

        // Check diagonal
        else {
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
        }

        return true;
    }
}
