package MVC;

import Vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

class CarVelocityPanel extends JPanel implements SpeedObserver, NumberOfCarsObserver {
    private final VehicleModel model;
    private final int X = 150;
    private int Y;
    private final int labelHeight = 20;

    CarVelocityPanel(VehicleModel model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.cyan);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setLabels(model.getNumberOfCars());
    }

    private void setPreferredSize(int X, int Y) {
        this.setPreferredSize(new Dimension(X, Y));
        repaint();
    }

    private void setLabels(int nrCars) {
        Y = nrCars * labelHeight;
        this.setPreferredSize(new Dimension(X, Y));

        model.iterator().forEachRemaining(car -> {
            JLabel label = new JLabel(String.format("%s : %.2f", car.getModelName(), car.getCurrentSpeed()));
            label.setPreferredSize(new Dimension(X, labelHeight));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(label);
        });
        repaint();
        this.updateUI();
    }

    private void updateLabels() {
        Iterator<Vehicle> vehicles = model.iterator();
        for (Component label : this.getComponents()) {
            Vehicle car = vehicles.next();
            if (label.getClass() == JLabel.class) {
                ((JLabel) label).setText(String.format("%s : %.2f", car.getModelName(), car.getCurrentSpeed()));
            }

        }
    }

    @Override
    public void speedHasChanged(List list) {
        updateLabels();
    }

    @Override
    public void carAdded(int nrCars) {
        removeAll();
        setLabels(nrCars);
    }

    @Override
    public void carRemoved(int nrCars) {
        removeAll();
        setLabels(nrCars);
    }

}
