package Vehicles;

import java.awt.*;

/**
 * A Vehicles.Truck-like object
 */
public class Scania extends Truck {

    /**
     * Angle of the truck's bed
     */
    private double bedAngle;
    public final static String modelName = "Scania";

    /**
     * Creates a Vehicles.Car-like object with the characteristics of a Scania truck
     */
    Scania() {
        super(2, 150, Color.white, modelName);
        this.bedAngle = 0;

    }

    /**
     * Get the angle of the truck's bed
     */
    public double getBedAngle() {
        return bedAngle;
    }

    /**
     * Checks if Bed is up
     *
     * @return If Bed is up!
     */
    @Override
    public boolean rampIsUp() {
        return getBedAngle() == 0;
    }

    /**
     * Tip the bed with 10degrees
     */
    @Override
    public void tip() {
        if (bedAngle == 70) {
            System.out.println("The bed is tipped to it's maximum");
        } else if (getCurrentSpeed() != 0) {
            System.out.println("THe Truck is moving");
        } else {
            this.bedAngle += 1 / 7.0 * 70;
        }
    }

    /**
     * Fold back the bed with 10degrees
     */
    @Override
    public void fold() {
        if (bedAngle == 0) {
            System.out.println("The bed is not tipped and can't be folded further");
        } else if (this.getCurrentSpeed() != 0) {
            System.out.println("THe Truck is moving");
        } else {
            this.bedAngle -= 1 / 7.0 * 70;
        }
    }


}
