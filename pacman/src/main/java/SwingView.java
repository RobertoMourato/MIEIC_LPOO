import javax.swing.*;

public class SwingView {
    protected DataBase database;

    public SwingView(){}
    public void start() {
        JFrame frame = new JFrame("Hello World Swing");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }
}

