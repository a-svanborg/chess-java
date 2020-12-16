import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class Game extends JFrame implements ActionListener {
    private Board Chessboard;
    private JLabel label = new JLabel();
    private JPanel Panel = new JPanel();
    private int Size = 8;
    private Color color;

    Game(Board chessboard) {
        Chessboard = chessboard;
        setSize(700, 700);
        setLocation(100, 150);
        setTitle("Chess");
        getContentPane().setBackground(Color.CYAN);
        restart();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revalidate();
    }

    public void restart() {
        Panel.removeAll();
        Panel = new JPanel();
        int counter = 1;

        for (int row = 0; row < Size; row++) {
            for (int col = 0; col < Size; col++) {
                if (counter % 2 == 0) {
                    color = Color.DARK_GRAY;
                } else {
                    color = Color.WHITE;
                }
                
                Piece current = Chessboard.GetStatus(row, col);
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
        System.out.println("hej!");


        Panel.setLayout(new GridLayout(Size + 1, Size));
        label = new JLabel(Chessboard.GetMessage());
        Panel.add(label);
        add(Panel);
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
        Game newgame = new Game(chessboard);
        scan.close();
    }
    
}
