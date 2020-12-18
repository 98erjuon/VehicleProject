package Vehicles;

import java.awt.*;

public abstract class Truck extends Vehicle implements Ramp {

    Truck(int doors, int enginePower, Color color, String modelName) {
        super(doors, enginePower, color, modelName);
    }

    double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        if (rampIsUp()) {
            super.gas(amount);
        } else {
            throw new IllegalStateException("Ramp is down!");
        }
    }

    @Override
    public void startEngine() {
        if (rampIsUp()) {
            super.startEngine();
        } else {
            throw new IllegalStateException("Ramp is down!");
        }
    }

    @Override
    public void move() {
        if (rampIsUp()) {
            super.move();
        }

    }
}