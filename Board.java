import java.awt.Color;

public class Board {
    private Piece[][] board = new Piece[8][8];
    private String CurrentMessage = "Welcome! White starts";
    private boolean whitesTurn = true;
    private int moveCounter = 0;
    private Piece choosenPiece;

    public Board() {
        Color black = Color.BLACK;
        Color white = Color.WHITE;
        // Put out all the pieces
        // White
        board[7][0] = new Rook(7, 0, white, "pictures/white_rook.png");
        board[7][1] = new Knight(7, 1, white, "pictures/white_knight.png");
        board[7][2] = new Bishop(7, 2, white, "pictures/white_bishop.png");
        board[7][3] = new Queen(7, 3, white, "pictures/white_queen.png");
        board[7][4] = new King(7, 4, white, "pictures/white_king.png");
        board[7][5] = new Bishop(7, 5, white, "pictures/white_bishop.png");
        board[7][6] = new Knight(7, 6, white, "pictures/white_knight.png");
        board[7][7] = new Rook(7, 7, white, "pictures/white_rook.png");
        for (int i = 0; i < board.length; i++) {
            board[6][i] = new Pawn(6, i, white, "pictures/white_pawn.png");
        }

        // Black
        board[0][0] = new Rook(0, 0, black, "pictures/black_rook.png");
        board[0][1] = new Knight(0, 1, black, "pictures/black_knight.png");
        board[0][2] = new Bishop(0, 2, black, "pictures/black_bishop.png");
        board[0][3] = new Queen(0, 3, black, "pictures/black_queen.png");
        board[0][4] = new King(0, 4, black, "pictures/black_king.png");
        board[0][5] = new Bishop(0, 5, black, "pictures/black_bishop.png");
        board[0][6] = new Knight(0, 6, black, "pictures/black_knight.png");
        board[0][7] = new Rook(0, 7, black, "pictures/black_rook.png");
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(1, i, black, "pictures/black_pawn.png");
        }

        // Empty squares in the middle
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Mock(i, j, Color.BLUE, "");
            }
        }
    }

    // returns piece at given place from the board
    public Piece GetPieceAt(int i, int j) {
        return board[i][j];
    }

    // Gives us messages to be put in the label
    public String GetMessage() {
        return CurrentMessage;
    }

    // Calls validMove to check the move. Also updates the board when a move is
    // succesful.
    public boolean Move(int i, int j, Piece piece) {
        Color c = whitesTurn ? Color.WHITE : Color.BLACK;
        // Moving requires two clicks
        // Choose piece to move. Has to be correct piece
        if (moveCounter == 0) {
            choosenPiece = GetPieceAt(i, j);
            Color pieceColor = choosenPiece.getColor();
            // Loop every square to find potentiall moves
            if (pieceColor == c) {
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        if (choosenPiece.validMove(board, choosenPiece, board[row][col])) {
                            board[row][col].inStrike = true;
                        }
                        board[row][col].isChecking = false;
                    }
                }

                board[i][j] = new Mock(i, j, Color.BLUE, "");
                moveCounter += 1;
                CurrentMessage = String.format("Place your piece");

            } else {
                CurrentMessage = String.format("It is %s turn now", whitesTurn == true ? "whites" : "blacks");
            }

        // Move choosen piece to location. Must check if move is valid.
        } else if (moveCounter == 1) {
            Piece newSquare = piece;

            // This if-statement allows us to place back the piece at the same square
            // without switching player.
            if (newSquare.getX() == choosenPiece.getX() && newSquare.getY() == choosenPiece.getY()) {
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        board[row][col].inStrike = false;
                        board[row][col].isChecking = false;
                    }
                }
                board[i][j] = choosenPiece;
                choosenPiece.setX(i);
                choosenPiece.setY(j);
                CurrentMessage = String.format("Still %s turn", whitesTurn == true ? "whites" : "blacks");
                moveCounter = 0;
            }

            else if (choosenPiece.validMove(board, choosenPiece, newSquare)) {
                // remove inStrike and isChecking
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        board[row][col].inStrike = false;
                        board[row][col].isChecking = false;
                    }
                }
                choosenPiece.hasMoved = true;
                board[i][j] = choosenPiece;
                choosenPiece.setX(i);
                choosenPiece.setY(j);
                CurrentMessage = String.format("Nice move. %s turn.", whitesTurn == true ? "Blacks" : "Whites");
                moveCounter = 0;
                whitesTurn = !whitesTurn;

                // Promotion
                if (choosenPiece instanceof Pawn && ((choosenPiece.getColor() == Color.WHITE && i == 0) || (choosenPiece.getColor() == Color.BLACK && i == 7))) {
                         board[i][j] = new Queen(i,j,choosenPiece.getColor(), choosenPiece.getColor() == Color.WHITE ? "pictures/white_queen.png" : "pictures/black_queen.png");
                     } 

                // Loop every square to find potentiall checks
                outerloop: for (int chosenRow = 0; chosenRow < 8; chosenRow++) {
                    for (int chosenCol = 0; chosenCol < 8; chosenCol++) {
                        for (int otherRow = 0; otherRow < 8; otherRow++) {
                            for (int otherCol = 0; otherCol < 8; otherCol++) {
                                if (board[chosenRow][chosenCol].validMove(board, board[chosenRow][chosenCol],
                                        board[otherRow][otherCol])) {
                                    if (board[otherRow][otherCol] instanceof King) {
                                        board[otherRow][otherCol].isChecking = true;
                                        board[chosenRow][chosenCol].isChecking = true;
                                        CurrentMessage = String.format("Check!");
                                        //break outerloop;
                                    }
                                }
                            }
                        }
                    }
                }

            } else {
                CurrentMessage = "Illegal move. Choose another square.";
            }

        }

        return true;
    }
}
