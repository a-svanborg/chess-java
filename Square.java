public class Square {
    // Has a position and a may have a piece
    private int xPosition;
    private int yPosition;
    private Piece piece;

    public Square(int xPosition, int yPosition, Piece piece) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public int getX(){
        return this.xPosition;
    }

    public int getY(){
        return this.yPosition;
    }

    public void setX(int x){
        this.xPosition = x;
    }

    public void setY(int y){
        this.yPosition = y;
    }

    public boolean occupied() {
        return (this.piece != null);
    }
}
