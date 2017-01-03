package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandDissociateButton implements Command {

    private Drawing drawing;
    private GroupForm groupForm;

    public CommandDissociateButton(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        for (Shape shape : drawing) {
            if(shape.isSelected && shape instanceof GroupForm) {
                this.groupForm = (GroupForm) shape;
            }
        }
        for(Shape shape2 : this.groupForm.getShapeList()) {
            drawing.addShape(shape2);
        }
        drawing.removeForm(this.groupForm);
    }

    @Override
    public void unexecute() {
        for(Shape shape : this.groupForm.getShapeList()) {
            drawing.removeForm(shape);
        }
        drawing.addShape(this.groupForm);
    }
}
