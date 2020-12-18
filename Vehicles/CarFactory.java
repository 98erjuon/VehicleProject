package Vehicles;

public class CarFactory {

    public static Vehicle createSaab95(){
        return new Saab95();
    }

    public static Vehicle createVolvo240(){
        return new Volvo240();
    }

    public static Vehicle createScania(){
        return new Scania();
    }

    public static Vehicle createCar(String model){
        if (model == null)
            return null;
        else if (model.equals(Saab95.modelName))
            return new Saab95();
        else if (model.equals(Volvo240.modelName))
            return new Volvo240();
        else if (model.equals(Scania.modelName))
            return new Scania();
        return null;
    }
}
