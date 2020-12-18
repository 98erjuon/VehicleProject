package MVC;

import Vehicles.*;
import Vehicles.CarFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VehicleModel implements Iterable<Vehicle> {
    private ArrayList<Vehicle> vehicles;
    private List<SpeedObserver> speedObservers = new ArrayList<>();
    private List<NumberOfCarsObserver> numberOfCarsObservers = new ArrayList<>();
    private String carToAdd = Volvo240.modelName;
    private int gasBreakAmount;

    VehicleModel() {
        this.vehicles = new ArrayList<>();
        this.gasBreakAmount = 50;

    }
    int getNumberOfCars() {
        return this.vehicles.size();
    }

    void addSpeedObserver(SpeedObserver observer) {
        this.speedObservers.add(observer);
    }
    void addNumberOfCarsObserver(NumberOfCarsObserver observer) {
        this.numberOfCarsObservers.add(observer);
    }
    private void notifySpeedHasChanged() {
        for (SpeedObserver observer : speedObservers) {
            observer.speedHasChanged(this.vehicles);
        }
    }
    private void notifyCarAdded() {
        for (NumberOfCarsObserver observer : numberOfCarsObservers) {
            observer.carAdded(vehicles.size());
        }
    }
    private void notifyCarRemoved() {
        for (NumberOfCarsObserver observer : numberOfCarsObservers) {
            observer.carRemoved(vehicles.size());
        }
    }

    void addCar() {
        Vehicle car = CarFactory.createCar(carToAdd);
        car.getLocationReference().setLocation(0,vehicles.size() * 75);
        this.vehicles.add(car);
        notifyCarAdded();
    }


    void addCar(Vehicle car) {
        car.getLocationReference().setLocation(0, vehicles.size() * 75);
        this.vehicles.add(car);
        notifyCarAdded();

    }
    void setCarToAdd(String carToAdd) {
        this.carToAdd = carToAdd;
    }

    void removeLastCar() {
        this.vehicles.remove(vehicles.size() - 1);
        notifyCarRemoved();
    }

    void setGasBrake(int amount) {
        this.gasBreakAmount = amount;
    }
    void gasAll() {
        vehicles.forEach(vehicle -> {
            try {
                vehicle.gas(gasBreakAmount / 100.0);
                System.out.println(vehicle.getLoc());
            } catch (IllegalStateException f) {
                System.out.println(f.getMessage());
            }
            ;
        });
        notifySpeedHasChanged();
    }
    void brakeAll() {
        vehicles.forEach(vehicle -> {
            try {
                vehicle.brake(gasBreakAmount / 100.0);
            } catch (IllegalStateException f) {
                System.out.println(f.getMessage());
            }
            ;
        });
        notifySpeedHasChanged();
    }
    void moveAll() {
        vehicles.forEach(vehicle -> {
            try {
                vehicle.move();
            } catch (IllegalStateException f) {
                System.out.println(f.getMessage());
            }
            ;
        });
    }

    void startAll() {
        vehicles.forEach(vehicle -> {
            try {
                vehicle.startEngine();
            } catch (IllegalStateException f) {
                System.out.println(f.getMessage());
            }
        });
        notifySpeedHasChanged();
    }
    void stopAll() {
        vehicles.forEach(Vehicle::stopEngine);
        notifySpeedHasChanged();
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == Saab95.class)
                ((Saab95) vehicle).setTurboOff();
        }
    }
    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == Saab95.class)
                ((Saab95) vehicle).setTurboOn();
        }
    }
    void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == Scania.class)
                ((Scania) vehicle).tip();
        }
    }
    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == Scania.class)
                ((Scania) vehicle).fold();
        }
    }

    void turnAllLeft(){
        vehicles.forEach(Vehicle::turnLeft);
    }

    void turnAllRight(){
        vehicles.forEach(Vehicle::turnRight);
    }



    @Override
    public Iterator<Vehicle> iterator() {
        return this.vehicles.iterator();
    }
}
