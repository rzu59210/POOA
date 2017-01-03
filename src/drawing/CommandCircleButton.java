package drawing;

import java.awt.*;

public class CommandCircleButton extends ShapeButtonListener implements Command{

    private Drawing drawing;
    private Circle circle;

    public CommandCircleButton(Drawing drawing) {
        super(drawing);
        this.drawing = drawing;
    }

    protected Shape createShape() {
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
    public void execute() {

    }

    @Override
    public void unexecute() {
        drawing.removeForm(circle);
    }
}
