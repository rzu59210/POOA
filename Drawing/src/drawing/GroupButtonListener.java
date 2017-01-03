package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by kevin on 12/12/2016.
 */
public class GroupButtonListener implements ActionListener {

    Drawing drawing;

    public GroupButtonListener(Drawing draw){
        this.drawing = draw;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GroupForm groupForm = new GroupForm();
        for(Shape s : drawing.shapes){
            groupForm.addForm(s);
        }
        for(Shape s : groupForm.getShapeList()){
            drawing.removeForm(s);
        }
        if(!groupForm.isEmpty()){
            drawing.addShape(groupForm);
        }

    }
}
