package drawing;

import java.awt.*;

public class CommandMove implements Command{

    private Drawing drawing;
    private Shape myShape;
    private Point start;
    private Point end;

    public CommandMove(Drawing drawing, Shape shape,Point point) {
        this.drawing = drawing;
        this.myShape = shape;
        this.start = point;
        this.end = myShape.origin;
    }

    @Override
    public void execute() {
        myShape.setOrigin(end);
        drawing.repaint();
    }

    @Override
    public void unexecute() {
        myShape.setOrigin(start);
        drawing.repaint();
    }
}
