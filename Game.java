import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Game extends JFrame implements ActionListener {
    private Board Chessboard;
    private JLabel label = new JLabel();
    private JPanel mainPanel = new JPanel();
    private JPanel Panel = new JPanel();
    private int Size = 8;
    private Color color;

    Game(Board chessboard) {
        Chessboard = chessboard;
        setSize(550, 650);
        setLocation(100, 150);
        setTitle("Chess");
        getContentPane().setBackground(Color.CYAN);
        restart();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revalidate();
    }

    public void restart() {
        mainPanel.removeAll();
        mainPanel = new JPanel();
        Panel.removeAll();
        Panel = new JPanel();
        int counter = 1;

        for (int row = 0; row < Size; row++) {
            for (int col = 0; col < Size; col++) {
                Piece current = Chessboard.GetStatus(row, col);

                if (current.isChecking){
                    color = Color.RED;
                }
                else if(current.inStrike){
                    color = Color.YELLOW;
                }
                else if (counter % 2 == 0) {
                    color = Color.DARK_GRAY;
                } else {
                    color = Color.WHITE;
                }
                
                // Promotion
                if (current instanceof Pawn && ((current.color == Color.WHITE && row == 0) || (current.color == Color.BLACK && row == 7))) {
                    Chessboard.board[row][col] = new Queen(row,col,current.color, current.color == Color.WHITE ? "pictures/white_queen.png" : "pictures/black_queen.png");
                } 

                Square sq = new Square(row, col, current, color);
                
                try {
                    String directory = current.getDir();
                    Image img = ImageIO.read(getClass().getResource(directory));
                    sq.setIcon(new ImageIcon(img));
                } catch (Exception e) {}

                sq.xPosition = row;
                sq.yPosition = col;
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
        Chessboard.Move(square.xPosition, square.yPosition, square.piece);
        restart();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        Board chessboard = new Board();
        new Game(chessboard);
        scan.close();
    }
    
}
