import java.awt.Color;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

    Pawn(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
        // TODO Auto-generated constructor stub
    }
    public boolean validMove(Board board, Square startSQ, Square endSQ) {
        return true;
    }
}
