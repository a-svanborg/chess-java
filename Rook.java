import java.awt.Color;

public class Rook extends Piece {

    Rook(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Currently moves like king which is ok for grade E
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        if (endP.color == startP.color) { 
            return false; 
        }
        int x = Math.abs(startP.xPosition - endP.xPosition); 
        int y = Math.abs(startP.yPosition - endP.yPosition);

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

        return true;
    }
}
