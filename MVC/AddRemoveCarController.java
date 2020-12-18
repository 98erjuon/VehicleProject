package MVC;

class AddRemoveCarController {
    private final VehicleModel model;
    private final AddRemoveCarPanel panel;

    AddRemoveCarController(VehicleModel model, AddRemoveCarPanel panel) {
        this.model = model;
        this.panel = panel;
        init();
    }
    private void init() {
        panel.addCarButton.addActionListener(e -> {
            if (model.getNumberOfCars() < 10) {
                model.addCar();
            }
            else {
                System.out.println("It's Full (max 10 cars");
            }
        });
        panel.removeCarButton.addActionListener(e -> {
            if (model.getNumberOfCars() > 0) {
                model.removeLastCar();
            }
            else {
                System.out.println("There are no cars to remove");
            }
        });
    }
}
