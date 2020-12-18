package Vehicles;

import java.awt.*;

public abstract class Car extends Vehicle implements Loadable<Person> {

    LoadableComponent<Person> seats;

    /**
     * Creates a car-like object
     *
     * @param doors       number of doors
     * @param enginePower engine power of the car
     * @param color       color of the car
     */
    Car(int doors, int enginePower, Color color, String modelName, int nr_seats) {
        super(doors, enginePower, color, modelName);
        LoadableComponent<Person> person = new LoadableComponent(nr_seats);


    }

    Car(int doors, int enginePower, Color color, String modelName, int nr_seats, int x, int y) {
        super(doors, enginePower, color, modelName, x, y);
        LoadableComponent<Person> person = new LoadableComponent(nr_seats);


    }


    /**
     * Defined by specific Vehicles.Car's characteristics
     */
    abstract double speedFactor();

    /**
     * Gas with the Vehicles.Car, increase the speed of the Vehicles.Car
     *
     * @param amount by of which degree to gas, interval [0,1].
     * @throws IllegalArgumentException if amount is not in [0,1]
     */
    public final void gas(double amount) {
        super.gas(amount);
    }

    /**
     * Brake with the Vehicles.Car, decrease the speed of the Vehicles.Car
     *
     * @param amount by which degree to brake, interval [0,1].
     * @throws IllegalArgumentException if amount is not in [0,1]
     */
    public final void brake(double amount) {
        super.brake(amount);
    }

    @Override
    public void load(Person personToLoad) {
        try {
            seats.load(personToLoad);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The seats are filled! No space left for more persons");
        }
    }

    @Override
    public Person drop() {
        try {
            return seats.drop(true);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The Vehicles.Car is empty!");
            return null;
        }
    }

    public Person drop(Person personToDrop) {
        try {
            return seats.drop(personToDrop);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void showLoadedObjects() {

    }

}





