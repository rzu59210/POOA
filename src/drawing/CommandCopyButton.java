package drawing;

public class CommandCopyButton implements Command{

    private Drawing drawing;
    private Shape shape;
    private Shape cloneShape;

    public CommandCopyButton(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        for (Shape shape : drawing) {
            if(shape.isSelected) {
                this.shape = shape;
            }
        }
        cloneShape = this.shape.clone();
        drawing.addShape(cloneShape);
    }

    @Override
    public void unexecute() {
        drawing.removeForm(cloneShape);
    }
}
