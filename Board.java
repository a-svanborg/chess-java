public class Board {
    Square[][] board;
    private String CurrentMessage = "";
    private boolean whitesTurn = true;
    private int moveCounter = 0;
    private Square mock = new Square(0, 0, new Pawn());

    public Board() {
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

    public Square GetStatus(int i, int j) {
        return board[i][j];
        
    }

    public String GetMessage() {
        return CurrentMessage;

    }

    public boolean Move(int i, int j) {
        try {
            //Move. Requires two clicks
            
            if (whitesTurn) { //move X
                Move2(i, j, "test");
                //CurrentMessage = "Spelare O tur";
                whitesTurn = false;

            } else { // move O
                Move2(i, j, "test");
                //CurrentMessage = "Spelare X tur";
            
        
            }
            return true;

        } catch (Exception e) {
            CurrentMessage = "Välj en position som finns på brädet";
            return false;
        }
    }


    public boolean Move2(int i, int j, String p){

        // Choose piece to move. Has to be correct piece
        if (moveCounter == 0) {
            if (GetStatus(i-1, j-1) == mock) {
                board[i-1][j-1] = mock;
                moveCounter += 1;
                CurrentMessage = String.format("%s: Placera i tom ruta",p);
            } else {
                CurrentMessage = String.format("%s: Välj egen pjäs",p);
        }
        
        // Move choosen piece to new empty location on the board
        } else if(moveCounter == 1) {
            if (GetStatus(i-1, j-1) == mock) {
                board[i-1][j-1] = mock;
                CurrentMessage = String.format("%s: Godkänd flytt. Nästa spelares tur",p);
                moveCounter = 0;
            } else {
                CurrentMessage = "Kan inte placera där. Välj annan ruta.";
            }
        }

        return true;
    }

    public boolean Place(int i, int j, Square mock){
        board[i-1][j-1] = mock;
    return true;
}



}
