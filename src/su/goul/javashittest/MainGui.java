package su.goul.javashittest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui {
    JFrame mainFrame;
    JButton btn;

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            disableBtnWithText("Mouse pressed");
        }
    };

    KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                disableBtnWithText("Enter pressed");
            }
        }
    };

    public MainGui() {
        this.mainFrame = new JFrame("Java Test");
        this.btn = new JButton("Кнопка");

        this.btn.setSize(40, 20);
        this.btn.addActionListener(this.btnListener);
        this.btn.addKeyListener(this.keyListener);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.mainFrame.setBounds((screen.width - 100) / 2, (screen.height - 100) / 2, 100, 100);
        this.mainFrame.setLayout(new GridLayout(1, 1));
        this.mainFrame.add(this.btn);
        this.mainFrame.setResizable(false);
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setVisible(true);
    }

    private void disableBtnWithText(String text) {
        this.btn.setEnabled(false);
        this.btn.setText(text);
    }
}
