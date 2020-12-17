import java.awt.Color;

public class Bishop extends Piece {

    Bishop(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
    }

    // Currently moves like king which is ok for grade E
    public boolean validMove(Piece[][] board, Piece startP, Piece endP) {
        if (endP.color == startP.color) { 
            return false; 
        }

        int x = Math.abs(startP.xPosition - endP.xPosition); 
        int y = Math.abs(startP.yPosition - endP.yPosition);

        // Check if diagonal
        if (x != y) { 
            return false;
        }

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
        return true;
    }
}
