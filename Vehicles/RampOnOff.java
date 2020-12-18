package Vehicles;

public class RampOnOff<T extends Vehicle> {

    private boolean dropLast;
    /**
     * Creates a Vehicles.Ramp-like object that can load Cars
     * @param capacity max number of objects that can be loaded
     * @param dropLast true = last object loaded is dropped first. false = first object loaded is dropped first
     */
    LoadableComponent<T> ramp;
    public RampOnOff(int capacity, boolean dropLast) {
         ramp = new LoadableComponent<>();
        this.dropLast = dropLast;
    }

    public void load(T obj, Vehicle transport) throws IllegalStateException  {
        if (obj.getLoc().distance(transport.getLoc()) < 1) {
            obj.setLocation(transport.getLocationReference());
            try {
                this.ramp.load(obj);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new IllegalStateException(String.format("The car is to far away! (condition: <1m) \n Vehicles.CarTransport: Location(%d,%d) ..." +
                    "\n Vehicles.Car: Location(%d,%d)", transport.getLoc().x, transport.getLoc().y, obj.getLoc().x, obj.getLoc().y));
        }
    }
    public T drop(Vehicle transport) {
        try {
            T obj = ramp.drop(dropLast);
            obj.setLocation(transport.getLoc());
            obj.getLoc().setLocation(obj.getLoc().x+1, obj.getLoc().y); //
            return obj;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("There are no cars to drop, ramp empty");
            return null;
        }
    }
    public void showLoadedObjects() {
        ramp.showLoadedObjects();
    }
}
