import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class GameView extends JFrame implements ActionListener {
    private Chess Chessboard;
    private JLabel label = new JLabel();
    private JPanel mainPanel = new JPanel();
    private JPanel Panel = new JPanel();
    private int Size = 8;

    GameView(Chess chessboard) {
        Chessboard = chessboard;
        setSize(550, 650);
        setLocation(100, 150);
        setTitle("Chess");
        getContentPane().setBackground(Color.CYAN);
        refresh();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revalidate();
    }

    public void refresh() {
        mainPanel.removeAll();
        mainPanel = new JPanel();
        Panel.removeAll();
        Panel = new JPanel();

        Color squareColor;
        int counter = 1;

        for (int row = 0; row < Size; row++) {
            for (int col = 0; col < Size; col++) {
                Piece current = Chessboard.GetPieceAt(row, col);

                if (current.isChecking){
                    squareColor = Color.RED;
                }
                else if(current.inStrike){
                    squareColor = Color.YELLOW;
                }
                else if (counter % 2 == 0) {
                    squareColor = Color.DARK_GRAY;
                } else {
                    squareColor = Color.WHITE;
                }
                
                Square sq = new Square(row, col, current, squareColor);
                
                try {
                    String directory = current.getDir();
                    Image img = ImageIO.read(getClass().getResource(directory));
                    sq.setIcon(new ImageIcon(img));
                } catch (Exception e) {}

                Panel.add(sq).setLocation(row * 100, col * 100);
                sq.addActionListener(this);
                counter++;
            }
            counter++;
        }

        Panel.setLayout(new GridLayout(Size + 1, Size));
        label = new JLabel(Chessboard.GetMessage());

        mainPanel.add(Panel);
        mainPanel.add(label);

        add(mainPanel);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Square square = (Square) e.getSource();
        Chessboard.Move(square.getXpos(), square.getYpos(), square.getPiece());
        refresh();
    }

    public static void main(String[] args) {
        Chess chessboard = new Chess();
        new GameView(chessboard);
    }
}
