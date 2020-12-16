import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;

public class Board {
    //Square[][] board;
    Piece[][] board = new Piece[8][8];
    private String CurrentMessage = "White starts";
    private boolean whitesTurn = true;
    private int moveCounter = 0;
    Color black = Color.BLACK;
    Color white = Color.WHITE;
    private Piece empty = new Pawn(0, 0, Color.BLUE, "");
    Piece choosenPiece;

    public Board() {
        //Put out all pieces

        //White
        board[0][0] = new Rook(0,0,white, "pictures/white_rook.png");
        board[0][1] = new Knight(0,1,white, "pictures/white_knight.png");
        board[0][2] = new Bishop(0,2,white, "pictures/white_bishop.png");
        board[0][3] = new Queen(0,3,white, "pictures/white_queen.png");
        board[0][4] = new King(0,4,white, "pictures/white_king.png");
        board[0][5] = new Bishop(0,5,white, "pictures/white_bishop.png");
        board[0][6] = new Knight(0,6,white, "pictures/white_knight.png");
        board[0][7] = new Rook(0,7,white, "pictures/white_rook.png");
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(1, i, white, "pictures/white_pawn.png");
        }

        //Black
        board[7][0] = new Rook(7,0,black, "pictures/black_rook.png");
        board[7][1] = new Knight(7,1, black, "pictures/black_knight.png");
        board[7][2] = new Bishop(7,2,black, "pictures/black_bishop.png");
        board[7][3] = new Queen(7,3,black, "pictures/black_queen.png");
        board[7][4] = new King(7,4,black, "pictures/black_king.png");
        board[7][5] = new Bishop(7,5,black, "pictures/black_bishop.png");
        board[7][6] = new Knight(7,6,black, "pictures/black_knight.png");
        board[7][7] = new Rook(7,7,black, "pictures/black_rook.png");
        for (int i = 0; i < board.length; i++) {
            board[6][i] = new Pawn(6,i,black, "pictures/black_pawn.png");
        }

        //Empty
        for (int i = 2; i < 6; i++) { 
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
    }

    public Piece GetStatus(int i, int j) {
        return board[i][j];
        
    }

    public String GetMessage() {
        return CurrentMessage;

    }

    public boolean Move(int i, int j, Piece piece) {
        try {
            //Moving requires two clicks
            
            if (whitesTurn) { 
                Move2(i, j, piece, Color.WHITE);
            } else {
                Move2(i, j, piece, Color.BLACK);
            }
            return true;

        } catch (Exception e) {
            CurrentMessage = "Välj en position som finns på brädet";
            return false;
        }
    }


    public boolean Move2(int i, int j, Piece endPiece, Color c){

        // Choose piece to move. Has to be correct piece
        if (moveCounter == 0) {
            choosenPiece = GetStatus(i, j);
            Color pieceColor = choosenPiece.getColor();
            if (pieceColor == c) {
                board[i][j] = null;
                moveCounter += 1;
                CurrentMessage = String.format("Place your piece");
            } else {
                CurrentMessage = String.format("Choose one of your own pieces");
        }
        
        // Move choosen piece to new empty location on the board
        } else if(moveCounter == 1) {
            ;
            if (choosenPiece.validMove(board, choosenPiece, endPiece)) {
                board[i][j] = choosenPiece;
                CurrentMessage = String.format("Nice move. Next players turn.");
                moveCounter = 0;
                whitesTurn = !whitesTurn;
            } else {
                CurrentMessage = "Illegal move. Choose another square.";
            }
        }

        return true;
    }

    public boolean Place(int i, int j, Piece empty){
        board[i-1][j-1] = empty;
    return true;
}



}
