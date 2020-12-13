public class Board {
    Square[][] board;

    public Board() {

    }
    public void initBoard() {
        //Put out all pieces

        //White
        board[0][0] = new Square(0, 0, new Rook());
        board[0][1] = new Square(0, 1, new Knight());
        board[0][2] = new Square(0, 2, new Bishop());
        board[0][3] = new Square(0, 3, new Queen());
        board[0][4] = new Square(0, 4, new King());
        board[0][5] = new Square(0, 5, new Bishop());
        board[0][6] = new Square(0, 6, new Knight());
        board[0][7] = new Square(0, 7, new Rook());
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Square(1, i, new Pawn());
        }

        //Black
        board[7][0] = new Square(7, 0, new Rook());
        board[7][1] = new Square(7, 1, new Knight());
        board[7][2] = new Square(7, 2, new Bishop());
        board[7][3] = new Square(7, 3, new Queen());
        board[7][4] = new Square(7, 4, new King());
        board[7][5] = new Square(7, 5, new Bishop());
        board[7][6] = new Square(7, 6, new Knight());
        board[7][7] = new Square(7, 7, new Rook());
        for (int i = 0; i < board.length; i++) {
            board[6][i] = new Square(6, i, new Pawn());
        }

        //Empty
        for (int i = 2; i < 6; i++) { 
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, null);
            }
        }
    }
}
