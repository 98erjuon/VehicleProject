package MVC;

import Vehicles.*;
import Vehicles.Vehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the MVC.View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */
class CarController extends JPanel implements KeyListener {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());
    private final VehicleModel model;
    private CarView frame;

   // private KeyInput keys;



    CarController(VehicleModel model, CarView frame) {
        this.model = model;
        this.frame = frame;
       // this.keys = new KeyInput(model);
        init();
    }
    void startTimer() {
        this.timer.start();
    }

    private void init() {
        frame.gasButton.addActionListener(e -> {
            model.gasAll();
        });
        frame.brakeButton.addActionListener(e -> {
            model.brakeAll();
        });
        frame.startButton.addActionListener(e -> {
            model.startAll();
        });
        frame.stopButton.addActionListener(e -> {
            model.stopAll();
        });
        frame.turboOnButton.addActionListener(e -> {
            model.turboOn();
        });
        frame.turboOffButton.addActionListener(e -> {
            model.turboOff();
        });
        frame.liftBedButton.addActionListener(e -> {
            model.liftBed();
        });
        frame.lowerBedButton.addActionListener(e -> {
            model.lowerBed();
        });
        frame.turnLeftButton.addActionListener(e -> {
            model.turnAllLeft();
        });
        frame.turnRightButton.addActionListener(e -> {
            model.turnAllRight();
        });
        frame.addKeyListener(new KeyListener(){

                                 @Override
                                 public void keyTyped(KeyEvent e) {

                                 }

                                 @Override
                                 public void keyPressed(KeyEvent e) {
                                     if (e.getKeyCode() == KeyEvent.VK_A)
                                         model.turnAllLeft();
                                     if (e.getKeyCode() == KeyEvent.VK_D)
                                         model.turnAllRight();
                                 }

                                 @Override
                                 public void keyReleased(KeyEvent e) {

                                 }
                             });


        frame.gasBrakeSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                model.setGasBrake((int) ((JSpinner) e.getSource()).getValue());
            }
        });
    }



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.iterator().forEachRemaining(car -> {
                turnIfEdge(car);
            });
            model.moveAll();
            frame.drawPanel.repaint();
        }
    }

    public void turnIfEdge(Vehicle vehicle) {
        int frameHeight = frame.drawPanel.getHeight();
        int frameWidth = frame.drawPanel.getWidth();
        if (vehicle.isDirNorth()
                && vehicle.getLoc().y - vehicle.getCurrentSpeed() <= 0) {
            vehicle.getLoc().setLocation(vehicle.getLoc().x, 0);
            vehicle.turnLeft();
            vehicle.turnLeft();
        } else if (vehicle.isDirSouth()
                && vehicle.getLoc().y + vehicle.getCurrentSpeed() >= frameHeight - 60) {
            vehicle.getLoc().setLocation(vehicle.getLoc().x, frameHeight - 60);
            vehicle.turnLeft();
            vehicle.turnLeft();
        } else if (vehicle.isDirWest()
                && vehicle.getLoc().x - vehicle.getCurrentSpeed() <= 0) {
            vehicle.getLoc().setLocation(0, vehicle.getLoc().y);
            vehicle.turnLeft();
            vehicle.turnLeft();
        } else if (vehicle.isDirEast()
                && vehicle.getLoc().x + vehicle.getCurrentSpeed() >= frameWidth - 100) {
            vehicle.getLoc().setLocation(frameWidth - 100, vehicle.getLoc().y);
            vehicle.turnLeft();
            vehicle.turnLeft();
        }
    }


/*
    private boolean carIsOB(Vehicle car) {
        int frameHeight = frame.drawPanel.getHeight();
        int frameWidth = frame.drawPanel.getWidth();
        if (car.getLoc().x > frameWidth - 100 ) {
            car.getLoc().setLocation(frameWidth - 100, car.getLoc().y);
        }
        else if (car.getLoc().x < 0) {
            car.getLoc().setLocation(1, car.getLoc().y);
        }
        else if (car.getLoc().y + 300 > frameHeight ) {
            car.getLoc().setLocation(car.getLoc().x, frameHeight - 300);
        }
        else if (car.getLoc().y < 0) {
            car.getLoc().setLocation(car.getLoc().x, 0);
        }
        else {
            return false;
        }
        return true;
    }

 */



}
