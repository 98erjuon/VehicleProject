package Vehicles;

import java.awt.*;

public class Saab95 extends Car {

    /**
     * True/false if turbo is on/off.
     */
    private boolean turboOn;
    public final static String modelName = "Saab95";


    /**
     * Creates a Vehicles.Car-like object with the characteristics of a Vehicles.Saab95
     */
    Saab95() {
        super(2, 125, Color.red, modelName, 4);
        this.turboOn = false;
    }



    /**
     * Returns the speed factor. Dependant on turboOn.
     *
     * @return the Vehicles.Car's speed factor
     */
    @Override
    double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Turn on turbo
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turn off turbo
     */
    public void setTurboOff() {
        turboOn = false;
    }


}
