import javax.swing.*;
import java.awt.event.*;

public class JButtonKeyDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KeyListener on JButton");
        JButton button = new JButton("Press Key");
        JLabel label = new JLabel("Waiting for key...");

        button.setBounds(100, 50, 100, 30);
        label.setBounds(100, 100, 200, 30);
        button.setFocusable(true);

        button.addKeyListener(new KeyAdapter() {
             void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + e.getKeyChar());
            }
        });

        frame.setLayout(null);
        frame.add(button);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}