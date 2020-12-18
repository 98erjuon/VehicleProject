package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

class CarView extends JFrame {
    private static final int X = 1150;
    private static final int Y = 800;

    // GasBrake Spinner Panel
    private final JPanel gasBrakePanel = new JPanel();
    JSpinner gasBrakeSpinner = new JSpinner();
    private final JLabel gasBrakeLabel = new JLabel("Amount of gas/brake");
    // Controller Panel
    private final JPanel controlPanel = new JPanel();
    final JButton gasButton = new JButton("Gas");
    final JButton brakeButton = new JButton("Brake");
    final JButton turboOnButton = new JButton("Saab Turbo on");
    final JButton turboOffButton = new JButton("Saab Turbo off");
    final JButton liftBedButton = new JButton("Lift Bed");
    final JButton lowerBedButton = new JButton("Lower Bed");
    final JButton startButton = new JButton("Start all cars");
    final JButton stopButton = new JButton("Stop all cars");
    final JButton turnLeftButton = new JButton("Turn left");
    final JButton turnRightButton = new JButton("Turn right");

    // Vehicles.Car visualization panel
    DrawPanel drawPanel;


    CarView(String framename, VehicleModel model) {
        drawPanel = new DrawPanel(X, Y - 240, model);
        initComponents(framename);
    }

    void addComponent(Component component, String layout) {
        this.add(component, layout);
        this.repaint();
        setVisible(true);

    }

    private void initComponents(String title) {
        // Adjust Frame
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        // init Spinner
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(50, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasBrakeSpinner = new JSpinner(spinnerModel);
        gasBrakePanel.setLayout(new BorderLayout());
        gasBrakePanel.add(gasBrakeLabel, BorderLayout.PAGE_START);
        gasBrakePanel.add(gasBrakeSpinner, BorderLayout.PAGE_END);


        this.add(gasBrakePanel);

        // init Controller Panel
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.setPreferredSize(new Dimension((X / 3), 200));
        controlPanel.setBackground(Color.CYAN);

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(turnLeftButton,6);
        controlPanel.add(turnRightButton,7);
        this.add(controlPanel);

        // init Start Button
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 8 - 15, 200));
        this.add(startButton);

        // init Stop Button
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 8 - 15, 200));
        this.add(stopButton, BorderLayout.WEST);







        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
