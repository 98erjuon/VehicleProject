package MVC;

import javax.swing.*;
import java.awt.*;

class AddRemoveCarPanel extends JPanel {
    private final int X = 100;
    private final int Y = 100;

    JButton addCarButton;
    JButton removeCarButton;

    AddRemoveCarPanel() {

        this.setDoubleBuffered(true);
        this.setLayout(new GridLayout(2, 1));
        this.setPreferredSize(new Dimension(X, Y));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        init();
    }

    private void init() {
        addCarButton = new JButton("Add car");
        addCarButton.setBackground(Color.green);
        removeCarButton = new JButton("Remove car");
        removeCarButton.setBackground(Color.red);

        this.add(addCarButton);
        this.add(removeCarButton);
        repaint();
    }
}
