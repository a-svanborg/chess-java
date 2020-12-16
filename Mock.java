import java.awt.Color;

// Invisible piece that lies on all "empty" squares
public class Mock extends Piece {
    Mock(int x, int y, Color c, String dir) {
        super(x, y, c, dir);
        
    }
}
