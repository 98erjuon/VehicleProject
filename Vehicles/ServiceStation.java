package Vehicles;

public class ServiceStation <CarModel extends Car> implements Loadable<CarModel> {

    // TreeMap<String, Vehicles.Car> garage;
    private LoadableComponent<CarModel> garage;

    public ServiceStation(int capacity) {
         //this.loadedCars = new TreeMap<>();
         this.garage = new LoadableComponent<>(capacity);
    }
    @Override
    public void load(CarModel car) {
        try {
            garage.load(car);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Don't have any more capacity!");
        }
    }
    public CarModel dropCar(CarModel carToRetrieve) {
        try {
            return garage.drop(carToRetrieve);
        }
        catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public CarModel drop() {
        try {
            return garage.drop(false);
        }
        catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void showLoadedObjects() {
        garage.showLoadedObjects();
    }
}
