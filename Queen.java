import java.awt.Color;

import javax.swing.ImageIcon;

public class Queen extends Piece {

    Queen(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
        // TODO Auto-generated constructor stub
    }
    public boolean validMove(Board board, Square startSQ, Square endSQ) {
        return true;
    }
}
