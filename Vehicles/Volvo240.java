package Vehicles;

import java.awt.*;

public class Volvo240 extends Car {

    /**
     * The Vehicles.Car's trim factor
     */
    private final static double trimFactor = 1.25;
    public final static String modelName =  "Volvo240";
    /**
     * Creates a Vehicles.Car-like object with the characteristics of a Volvo240
     */
    Volvo240() {
        super(4, 100, Color.black, modelName, 5);
    }


    /**
     * Returns the speed factor. Dependant on trimFactor
     *
     * @return the Vehicles.Car's speed factor
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }



}




