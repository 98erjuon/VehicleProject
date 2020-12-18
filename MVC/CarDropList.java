package MVC;

import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CarDropList extends JComboBox {
     CarDropList(VehicleModel model) {
        super(new String[]{Volvo240.modelName, Saab95.modelName, Scania.modelName});
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String modelName = (String)cb.getSelectedItem();
                model.setCarToAdd(modelName);
            }
        });
    }

}
