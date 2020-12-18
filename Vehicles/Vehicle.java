package Vehicles;

import java.awt.*;

public abstract class Vehicle implements Movable {

    /**
     * Number of doors on the Vehicles.Car
     */
    private int nrDoors;
    /**
     * Engine power of the car
     */
    private double enginePower;
    /**
     * Color of the car
     */
    private Color color;
    /**
     * The Vehicles.Car's model name
     */
    private final String modelName;
    /**
     * The current speed of the car
     */
    private double currentSpeed;

    private Point loc;
    private Direction dir;
    protected enum Direction {
        NORTH, WEST, SOUTH, EAST;
        Direction left() {
            switch (this) {
                case NORTH:
                    return WEST;
                case WEST:
                    return SOUTH;
                case SOUTH:
                    return EAST;
                default:
                    return NORTH;
            }
        }
        Direction right() {
            switch (this) {
                case NORTH:
                    return EAST;
                case WEST:
                    return NORTH;
                case SOUTH:
                    return WEST;
                default:
                    return SOUTH;
            }
        }
    }



    /**
     * Creates a Vehicles.Vehicle-like object
     * @param doors number of doors
     * @param enginePower engine power of the car
     * @param color color of the car
     */
    Vehicle(int doors, int enginePower, Color color, String modelName) {

        this.nrDoors = doors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.loc = new Point(0,0);
        this.dir = Direction.EAST;

        stopEngine();
    }

    public Vehicle(int doors, int enginePower, Color color, String modelName, int x, int y) {

        this.nrDoors = doors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.loc = new Point(x,y);
        this.dir = Direction.EAST;

        stopEngine();
    }



    /**
     * Get the Vehicles.Car's number of doors
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }
    /**
     * Get the Vehicles.Car's engine power
     * @return engine power
     */
    public double getEnginePower() {
        return enginePower;
    }
    /**
     * Get the Vehicles.Car's current speed
     * @return current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    /**
     * Get the color of the Vehicles.Car
     * @return color of the Vehicles.Car
     */
    public Color getColor() {
        return color;
    }
    /**
     * Changes the color of the Vehicles.Car
     * @param clr the color it changes to
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * sets current speed to 0.1
     */
    public void startEngine() {
        if (currentSpeed == 0)
           currentSpeed = 0.1;
        else throw new IllegalStateException("Engine already running!");
    }
    /**
     * sets current speed to 0
     */
    public void stopEngine() {
        currentSpeed = 0;
    }


    /**
     * Moves the car from one location to a new one, depending on the current speed and direction
     */
    @Override
    public void move() {
        switch(dir) {
            case NORTH:
                loc.y = (int) (loc.getY() - currentSpeed);
                break;
            case WEST:
                loc.x = (int) (loc.getX() - currentSpeed);
                break;
            case SOUTH:
                loc.y = (int) (loc.getY() + currentSpeed);
                break;
            case EAST:
                loc.x = (int) (loc.getX() + currentSpeed);
                break;
        }
    }
    /**
     * Changes direction of the Vehicles.Car 90deg counterclockwise
     */

    @Override
    public void turnLeft() {
        this.dir = dir.left();
    }
    /**
     * Changes direction of the Vehicles.Car 90deg clockwise
     */
    @Override
    public void turnRight() {
        this.dir = dir.right();
    }

    public Point getLoc() {
        return this.loc.getLocation();
    }
    public Point getLocationReference() {
        return this.loc;
    }

    public void setLocation(Point new_loc) {
        this.loc = new_loc;
    }

    public Direction getDirection() {
        return this.dir;
    }
    /**
     * Increase the speed of the Vehicles.Car
     *
     * @param amount by which factor to increase the speed
     */
    void incrementSpeed(double amount) {
        double new_speed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if (new_speed < 0) {
            currentSpeed = 0;
        } else {
            currentSpeed = new_speed;
        }
    }
    /**
     * Decreases the speed of the Vehicles.Car
     *
     * @param amount by which factor to decrease the speed
     */
    void decrementSpeed(double amount) {
        double new_speed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (new_speed > getEnginePower()) {
            currentSpeed = getEnginePower();
        } else {
            currentSpeed = new_speed;
        }
    }

    abstract double speedFactor();

    /**
     * Gas with the Vehicles.Car, increase the speed of the Vehicles.Car
     * @param amount by of which degree to gas, interval [0,1].
     * @throws IllegalArgumentException if amount is not in [0,1]
     */
    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be [0,1]");
        }
        incrementSpeed(amount);
    }
    /**
     * Brake with the Vehicles.Car, decrease the speed of the Vehicles.Car
     * @param amount by which degree to brake, interval [0,1].
     * @throws IllegalArgumentException if amount is not in [0,1]
     */
    public void brake(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be [0,1]");
        }
        decrementSpeed(amount);
    }
    @Override
    public String toString() {
        return modelName;
    }

    public String getModelName() {
        return modelName;
    }
    public boolean isDirNorth() {
        return this.dir == Direction.NORTH;
    }
    public boolean isDirEast() {
        return this.dir == Direction.EAST;
    }
    public boolean isDirSouth() {
        return this.dir == Direction.SOUTH;
    }
    public boolean isDirWest() {
        return this.dir == Direction.WEST;
    }
}

