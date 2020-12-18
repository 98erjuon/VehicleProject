package MVC;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

// This panel represent the animated part of the view with the car images.

class DrawPanel extends JPanel {
    private final VehicleModel model;

    // private final HashMap<String, BufferedImage> imageMap2 = new HashMap<>();

     DrawPanel(int x, int y, VehicleModel model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.iterator().forEachRemaining(car -> {

            try {
                g.drawImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.getModelName() + ".jpg")), car.getLoc().x, car.getLoc().y, null);
            } catch (IOException e) {
                System.out.println("Can't find Image");
            }
        });

    }
}

