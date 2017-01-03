package drawing;

import java.awt.*;

public class CommandCircleButton extends ShapeButtonListener {

    private Circle circle;

    public CommandCircleButton(Drawing drawing) {
        super(drawing);
        System.out.println("Instance du cercle");
    }

    @Override
    protected Shape createShape() {
        System.out.println("Former créer");
        double width = Math.abs(destination.getX() - origin.getX());
        double height = Math.abs(destination.getY() - origin.getY());
        double radius = Math.max(width, height) / 2;
        double centerX = (destination.getX() + origin.getX()) / 2;
        double centerY = (destination.getY() + origin.getY()) / 2;
        Point center = new Point((int) centerX, (int) centerY);
        this.circle = new Circle(center, radius, Color.RED);
        return circle;
    }



    @Override
    public void unexecute() {
        drawing.removeForm(circle);
    }
}
