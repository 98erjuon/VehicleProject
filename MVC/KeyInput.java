package MVC;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

    VehicleModel model;

    public KeyInput(VehicleModel model) {
        this.model = model;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_A)
            model.turnAllLeft();
        if (e.getKeyCode() == KeyEvent.VK_D)
            model.turnAllRight();
    }

}

