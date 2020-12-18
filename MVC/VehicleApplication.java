package MVC;

import Vehicles.CarFactory;

import java.awt.*;

public class VehicleApplication {
    public static void main (String[] args){
        // initiating the Model, main Frame and main Controller
        VehicleModel model = new VehicleModel();
        CarView frame = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(model, frame);

        // Adding Cars
        model.addCar(CarFactory.createSaab95());

        //Velocity Panel
        CarVelocityPanel velPanel = new CarVelocityPanel(model);
        model.addSpeedObserver(velPanel);
        model.addNumberOfCarsObserver(velPanel);
        //Add and Remove car Panel
        AddRemoveCarPanel addRemovePanel = new AddRemoveCarPanel();
        AddRemoveCarController addRemoveController = new AddRemoveCarController(model, addRemovePanel);
        // Vehicles.Car Drop List
        CarDropList carDropList = new CarDropList(model);

        //Adding the Components
        frame.addComponent(velPanel, BorderLayout.LINE_END);
        frame.addComponent(addRemovePanel, BorderLayout.LINE_END);
        frame.addComponent(carDropList, BorderLayout.SOUTH);
        cc.startTimer();

    }
}
