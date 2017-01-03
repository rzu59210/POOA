package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CommandGroupButton implements Command {

    private Drawing drawing;
    private GroupForm groupForm;

    public CommandGroupButton(Drawing draw){
        this.drawing = draw;
    }

    @Override
    public void execute() {
        this.groupForm = new GroupForm();
        for (Shape shape : drawing) {
            if (shape.isSelected) {
                this.groupForm.addForm(shape);
            }
        }

        for(Shape shape : this.groupForm.getShapeList()) {
            drawing.removeForm(shape);
        }
        drawing.addShape(this.groupForm);
        System.out.println("Groupe crée");
    }

    @Override
    public void unexecute() {
        for(Shape shape : this.groupForm.getShapeList()) {
            drawing.addShape(shape);
        }
        drawing.removeForm(this.groupForm);
    }
}
