import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Game extends JFrame implements ActionListener{
    private Board Chessboard;

    Game(Board chessboard) {
        Chessboard = chessboard;
        setSize(700, 700);
        setLocation(100, 150);
        setTitle("Chess");
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        Board chessboard = new Board();
        Game newgame = new Game(chessboard);
    }
    
}
