package Vehicles;

import java.awt.*;

/**
 * A Vehicles.CarTransport, with capacity of carrying 8 Cars
 */
public class CarTransport extends Truck implements Loadable<Car> {

    /**
     * Vehicles.Ramp-like object, that can store Vehicles.Car-objects
     */
    private RampOnOff<Car> ramp;
    private boolean rampUp;

    /**
     * Creates a Vehicles.Car-Transport, car-like object, that can hold Vehicles.Car's on it's ramp
     */
    public CarTransport() {
        super(2, 200, Color.BLUE, "CT100");
        this.ramp = new RampOnOff(8, true);
        this.rampUp = true;
    }

    /**
     * Load the transport
     * @param car A Vehicles.Car-like object to load the transport with
     */
    @Override
    public void load(Car car) {
        if (!rampUp) {
            try {
                ramp.load(car, this);
            }
            catch (IllegalStateException e) {
                System.out.println("Vehicles.Car too far away!");
            }
        }
        else {
            System.out.println("Cant load Vehicles.Car while Vehicles.Ramp is up!");
        }
    }
    /**
     * Drops the LAST loaded Vehicles.Car-object
     * @return the dropped Vehicles.Car
     */
    @Override
    public Car drop() {
        if (!rampUp) {
            return ramp.drop(this);
        }
        else {
            System.out.println("Cant drop Vehicles.Car while Vehicles.Ramp is up!");
            return null;
        }
    }
    /**
     * Show Cars on the Vehicles.Ramp
     */
    @Override
    public void showLoadedObjects() {
        ramp.showLoadedObjects();
    }


    /**
     * Checks if Bed is up
     * @return If Bed is up!
     */
    @Override
    public boolean rampIsUp() {
        return rampUp;
    }
    /**
     * Tips the bed
     */
    @Override
    public void tip() {
        if (getCurrentSpeed() == 0 && this.rampUp) {
            this.rampUp = false;
        }
        else if (getCurrentSpeed() != 0){
            System.out.println("Vehicles.CarTransport is Moving");
        }
        else {
            System.out.println("Vehicles.Ramp is already tipped");
        }
    }
    /**
     * Folds the bed
     */
    @Override
    public void fold() {
        if (getCurrentSpeed() == 0 && !this.rampUp) {
            this.rampUp = true;
        }
        else if (getCurrentSpeed() != 0){
            System.out.println("Vehicles.CarTransport is Moving");
        }
        else {
            System.out.println("Vehicles.Ramp is already folded");
        }
    }




}
