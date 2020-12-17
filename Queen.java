import java.awt.Color;

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

        if (x != y && !(startP.xPosition == endP.xPosition || startP.yPosition == endP.yPosition)) { 
            return false;
        }

        // Check horizontal and vertical
        if (startP.xPosition == endP.xPosition || startP.yPosition == endP.yPosition) {
            if (startP.xPosition == endP.xPosition) {
                //Left
                if (startP.yPosition > endP.yPosition) {
                    //Loop through all squares between.
                    for (int i = 1; i < y; i++) {
                        Piece currentSquare = board[startP.xPosition][startP.yPosition - i];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                    }
                //Right
                } else {
                    for (int i = 1; i < y; i++) {
                        Piece currentSquare = board[startP.xPosition][startP.yPosition + i];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                    }
                }
            } else if (startP.yPosition == endP.yPosition) {
                //Down
                if (startP.xPosition < endP.xPosition) {
                    //Loop through all squares between.
                    for (int i = 1; i < x; i++) {
                        Piece currentSquare = board[startP.xPosition + i][startP.yPosition];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                    }
                //Up
                } else {
                    for (int i = 1; i < x; i++) {
                        Piece currentSquare = board[startP.xPosition - i][startP.yPosition];
                        if (currentSquare.color != Color.BLUE) {
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
            if (startP.xPosition > endP.xPosition && startP.yPosition < endP.yPosition) {
                for (int i = 1; i < x; i++) {
                    Piece currentSquare = board[startP.xPosition - i][startP.yPosition + i];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                }
            // down left
            } else if (startP.xPosition < endP.xPosition && startP.yPosition > endP.yPosition) {
                for (int i = 1; i < x; i++) {
                    Piece currentSquare = board[startP.xPosition + i][startP.yPosition - i];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                }
            // up left
            } else if (startP.xPosition > endP.xPosition && startP.yPosition > endP.yPosition) {
                for (int i = 1; i < x; i++) {
                    Piece currentSquare = board[startP.xPosition - i][startP.yPosition - i];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                }
            // down right
            } else {
                for (int i = 1; i < x; i++) {
                    Piece currentSquare = board[startP.xPosition + i][startP.yPosition + i];
                        if (currentSquare.color != Color.BLUE) {
                            return false;
                        }
                }
            }
        }

        return true;
    }
}
