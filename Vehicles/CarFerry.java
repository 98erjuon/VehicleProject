package Vehicles;

import java.awt.*;

/**
 * Vehicles.Ramp-like object, that can store Vehicles.Car-objects
 */
public class CarFerry extends Vehicle implements Ramp, Loadable<Car> {

    private RampOnOff<Car> cargo;
    private boolean docked;

    CarFerry() {
        super(2, 200, Color.BLUE, "CT100");
        this.cargo = new RampOnOff(200, false);
        this.docked = true;
    }

    @Override
    public void load(Car car) {
        if (this.docked) {
            try {
                cargo.load(car, this);
            } catch (IllegalStateException e) {
                System.out.println("Vehicles.Car too far away!");
            }
        } else {
            System.out.println("Ferry need to be docked");
        }
    }

    @Override
    public Car drop() {
        return cargo.drop(this);
    }

    public void showLoadedObjects() {
        cargo.showLoadedObjects();
    }


    @Override
    public boolean rampIsUp() {
        return !docked;
    }

    @Override
    public void tip() {
        if (getCurrentSpeed() == 0 && this.docked == false) {
            this.docked = true;
        } else if (getCurrentSpeed() != 0) {
            System.out.println("Ferry is Moving");
        } else {
            System.out.println("Ferry's bed is already docked");
        }
    }

    @Override
    public void fold() {
        if (!rampIsUp()) {
            this.docked = false;
        } else {
            System.out.println("Ferry's bed is already docked");
        }
    }

    @Override
    double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        if (rampIsUp()) {
            super.move();
        } else {
            System.out.println("Ferry is docked!");
        }
    }
}

