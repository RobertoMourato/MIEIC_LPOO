import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingView extends JFrame {
    DataBase database;
    Display display;
    Rule rule;
    final int WIDTH = 930;
    final int HEIGHT = 750;



    public SwingView(){


         database = new DataBase();

         rule = new Rule(database);

         display = new Display(rule, database);

    }




    public void start() {

            JFrame frame = new JFrame("PacMAN");
            frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
            frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.getContentPane().add(display);
            frame.pack();
            frame.setVisible(true);


    }
}

