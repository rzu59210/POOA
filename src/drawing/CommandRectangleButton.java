package drawing;

import java.awt.*;

public class CommandRectangleButton extends ShapeButtonListener implements Command{

    private Drawing drawing;
    private Rectangle rectangle;

    public CommandRectangleButton(Drawing drawing) {
        super(drawing);
        this.drawing = drawing;
    }

    @Override
    protected Shape createShape() {
        double width = Math.abs(destination.getX() - origin.getX());
        double height = Math.abs(destination.getY() - origin.getY());
        this.rectangle = new Rectangle(origin, (int) width, (int) height, Color.BLUE);
        return rectangle;
    }

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {
        drawing.removeForm(this.rectangle);
    }
}
